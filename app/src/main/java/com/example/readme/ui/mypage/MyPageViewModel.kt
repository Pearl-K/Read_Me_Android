package com.example.readme.ui.mypage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.readme.data.remote.MyPageResponse
import com.example.readme.data.remote.ReadmeServerService
import com.example.readme.utils.RetrofitClient.apiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyPageViewModel(private val token: String, private val apiService: ReadmeServerService) : ViewModel() {

    private val _myPage = MutableLiveData<MyPageResponse>()
    val myPage: LiveData<MyPageResponse> get() = _myPage

    // MyPage 정보를 가져오는 함수
    fun fetchMyPage(): LiveData<MyPageResponse> {
        viewModelScope.launch {
            try {
                // API 호출 시 토큰을 헤더에 추가
                val response = apiService.getMyProfile("Bearer $token")

                if (response.isSuccess) {
                    val myPageResponse = response

                    // myPageResponse가 null이 아닌 경우에만 처리
                    myPageResponse?.let {
                        _myPage.postValue(it)
                    } ?: run {
                        Log.e("MyPageViewModel", "MyPage response body is null")
                    }
                } else {
                    Log.e("MyPageViewModel_fetchMyPage", "Error: ${response.code} - ${response.message}")
                }
            } catch (e: Exception) {
                Log.e("MyPageViewModel_fetchMyPage", "Exception: ${e.message}")
            }
        }
        return myPage
    }
}
