package com.example.readme.ui.mypage

import MyPageViewModelFactory
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.readme.R
import com.example.readme.databinding.FragmentMypageBinding
import androidx.fragment.app.viewModels
import com.example.readme.data.remote.ProfileResponse
import com.example.readme.data.remote.ReadmeServerService
import com.example.readme.ui.MainActivity
import com.example.readme.utils.RetrofitClient
import com.example.whashow.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private val information = arrayListOf("내 쇼츠", "찜 쇼츠", "읽은 책")

    private val token: String = "your_access_token" // 실제 토큰으로 대체
    private val apiService: ReadmeServerService by lazy {
        RetrofitClient.apiService
    }
    private val viewModel: MyPageViewModel by viewModels {
        MyPageViewModelFactory(token, apiService)
    }

    override fun initStartView() {
        super.initStartView()
        (activity as MainActivity).ShowMyPage()
    }

    override fun initDataBinding() {
        super.initDataBinding()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun initAfterBinding() {
        super.initAfterBinding()

        // ViewPager2와 TabLayoutMediator 설정
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = information[position]
        }.attach()

        // 프로필 정보 가져오기
        viewModel.getProfile(token).observe(viewLifecycleOwner) { profileResponse ->
            // 프로필 정보를 UI에 업데이트하기
        }


    }

    // 이전 방식
    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 여기서 super.onCreateView 호출로 _binding을 설정
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = information[position]
        }.attach()

        return binding.root
    }*/

}