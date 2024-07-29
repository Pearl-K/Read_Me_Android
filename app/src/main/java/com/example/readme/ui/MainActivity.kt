package com.example.readme.ui

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.readme.R
import com.example.readme.databinding.ActivityMainBinding
import com.example.readme.ui.community.CommunityFragment
import com.example.readme.ui.home.HomeFragment
import com.example.readme.ui.mypage.MyPageFragment
import com.example.readme.ui.search.SearchFragment
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Readme)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ShowInit()
        setupBottomNavigationView()
        setSupportActionBar(binding.toolbar)
        // Disable displaying the title in the Toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager
                .popBackStack()
        }
        else {
            super.onBackPressed()
        }
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment? = when (item.itemId) {
                R.id.navigation_home -> HomeFragment()
                R.id.navigation_search -> SearchFragment()
                R.id.navigation_community -> CommunityFragment()
                R.id.navigation_mypage -> MyPageFragment()
                else -> null
            }
            selectedFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, it)
                    .commit()
            }
            true
        }
        // Set default selection
        binding.bottomNavigationView.selectedItemId = R.id.navigation_home
    }

    fun ShowInit(){
        binding.mainLogo.visibility = View.VISIBLE
        binding.btnFilter.visibility = View.VISIBLE
        binding.btnSetting.visibility = View.GONE
        binding.btnBack.visibility = View.GONE
    }


    fun ShowHome(){
        binding.mainLogo.visibility = View.VISIBLE
        binding.btnFilter.visibility = View.VISIBLE
        binding.btnSetting.visibility = View.GONE
        binding.btnBack.visibility = View.GONE
    }

    fun ShowSearch(){
        binding.mainLogo.visibility = View.GONE
        binding.btnFilter.visibility = View.GONE
        binding.btnSetting.visibility = View.GONE
        binding.btnBack.visibility = View.GONE
        binding.search.visibility = View.VISIBLE
    }



}

