package com.example.readme.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readme.data.entities.BookInfo
import com.example.readme.data.repository.SearchRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class BookSearchPreviewViewModel(
    private val repository: SearchRepository
) : ViewModel() {
    private val TAG = BookSearchPreviewViewModel::class.java.simpleName
    private val _searchBookItems = MutableLiveData<List<BookInfo>?>()
    val searchBookItems: LiveData<List<BookInfo>?> get() = _searchBookItems

    // MutableStateFlow to hold the search query and pagination state
    private val queryFlow = MutableStateFlow("")
    private val pageFlow = MutableStateFlow(1)

    private var isLoading = false
    private var hasNext = true

    init {
        viewModelScope.launch {
            queryFlow
                .debounce(400) // 400ms debounce time to prevent excessive API calls
                .distinctUntilChanged() // Only proceed if the query actually changes
                .filter { it.isNotBlank() } // Ignore empty queries
                .onEach { resetPagination() } // Reset pagination on query change
                .collect { query ->
                    searchBook(query, pageFlow.value)
                }
        }

        viewModelScope.launch {
            pageFlow
                .filter { it > 1 } // Only collect if pageFlow is greater than 1
                .collect { page ->
                    if (hasNext && !isLoading) {
                        searchBook(queryFlow.value, page)
                    }
                }
        }
    }

    fun onQueryTextChange(newQuery: String) {
        queryFlow.value = newQuery
    }

    fun loadMore() {
        if (!isLoading && hasNext) {
            pageFlow.value += 1
        }
    }

    private fun resetPagination() {
        pageFlow.value = 1
        hasNext = true
    }

    private fun searchBook(query: String, page: Int) {
        if (isLoading) return
        isLoading = true

        viewModelScope.launch {
            try {
                // Retrofit API 호출
                val response = repository.searchBooksPreview(query, page, 50)
                Log.i(TAG, "response: $response")

                // 응답이 성공일 경우
                if (response.isSuccess) {
                    val items = response.result
                    val currentList = _searchBookItems.value.orEmpty()
                    _searchBookItems.postValue(currentList + items)

                    // Check if there are more pages
                    if (items.size < 50) {
                        hasNext = false
                    }
                } else {
                    // 실패한 경우
                    Log.e(TAG, "Failed to fetch search book items: ${response.code} - ${response.message}")
                }
            } catch (e: Exception) {
                // 예외 발생한 경우
                Log.e(TAG, "Error fetching search book items", e)
            } finally {
                isLoading = false
            }
        }
    }
}
