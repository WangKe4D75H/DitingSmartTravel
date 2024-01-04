package com.example.ditingsmarttravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 设置顶部状态栏
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // 初始化界面和底部菜单栏
        viewPager = findViewById(R.id.view_pager)
        bottomNav = findViewById(R.id.bottom_nav)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_schedule -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.nav_live -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.nav_me -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
    }

    private inner class ScreenSlidePagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ScheduleFragment()
                1 -> LiveFragment()
                else -> MeFragment()
            }
        }
    }
}