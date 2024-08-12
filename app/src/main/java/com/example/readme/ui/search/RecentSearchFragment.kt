package com.example.readme.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readme.R
import com.example.readme.data.repository.SearchRepository
import com.example.readme.databinding.FragmentRecentSearchBinding
import com.example.readme.ui.MainActivity
import com.example.readme.ui.base.BaseFragment
import com.example.readme.ui.search.book.BookDetailFragment

class RecentSearchFragment : BaseFragment<FragmentRecentSearchBinding>(R.layout.fragment_recent_search) {
    private val viewModel: RecentSearchViewModel by viewModels {
        RecentSearchViewModelFactory(SearchRepository)
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // RecyclerView 레이아웃 매니저 설정
        binding.recentSearchesRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun initAfterBinding() {
        super.initAfterBinding()

        // RecyclerView 어댑터 설정
        val adapter = RecentSearchAdapter(
            onBookClick = { bookId ->
                // 책 상세 화면으로 전환
                val bookDetailFragment = BookDetailFragment()
                val bundle = Bundle()
                bundle.putInt("bookId", bookId)
                bookDetailFragment.arguments = bundle
                Log.d("RecentSearchFragment", "bookId: ${bookDetailFragment.arguments?.getInt("bookId")}")
                (activity as MainActivity).addFragment(BookDetailFragment())
            },
            onQueryClick = { query ->
                // 검색 결과 화면으로 전환
                val parentFragment = parentFragment
                if (parentFragment is SearchFragment) {
                    parentFragment.setQuery(query)
                    val searchResultFragment = SearchResultFragment()
                    val bundle = Bundle().apply {
                        putString("keyword", query)
                    }
                    searchResultFragment.arguments = bundle
                    parentFragment.setFragment(searchResultFragment)
                }
            },
            onDeleteClick = { item ->
                viewModel.removeSearchItem(item) // 검색어 삭제 처리
            }
        )
        binding.recentSearchesRecyclerView.adapter = adapter

        // RecentSearch 목록 갱신
        viewModel.fetchRecentSearchItems().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}
