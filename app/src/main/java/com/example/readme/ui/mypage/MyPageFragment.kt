package com.example.readme.ui.mypage

import MyPageViewModelFactory
import com.example.readme.R
import com.example.readme.databinding.FragmentMypageBinding
import androidx.fragment.app.viewModels
import com.example.readme.data.remote.ReadmeServerService
import com.example.readme.ui.MainActivity
import com.example.readme.utils.RetrofitClient
import com.example.readme.ui.base.BaseFragment
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
            when(position){
                0 -> { tab.setIcon(R.drawable.ic_tab_shorts) }
                1 -> { tab.setIcon(R.drawable.ic_tab_likes) }
                2 -> { tab.setIcon(R.drawable.ic_tab_books) }
            }
        }.attach()

        // 프로필 정보 가져오기
        viewModel.getMyProfile(token).observe(viewLifecycleOwner) { profileResponse ->
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