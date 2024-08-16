package com.example.readme.ui.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.readme.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)  // Ensure the correct layout file name

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager)
        val tablayout: TabLayout = findViewById(R.id.tablayout)

        val fragmentAdapter = FragmentAdapter(this)
        fragmentAdapter.addFragment(CommunitySearchFragment(), "탐색하기")
        fragmentAdapter.addFragment(CreateFragment(), "개설하기")
        fragmentAdapter.addFragment(MyChatFragment(), "나의 채팅방")

        viewPager2.adapter = fragmentAdapter


        TabLayoutMediator(tablayout, viewPager2) { tab, position ->
            tab.text = fragmentAdapter.getPageTitle(position)
        }.attach()
    }
}