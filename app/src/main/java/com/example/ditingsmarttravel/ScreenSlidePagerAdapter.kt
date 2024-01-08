package com.example.ditingsmarttravel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3 // 该适配器用于实现“行程”，“实况”，“我”三个页面之间的滑动切换

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TripFragment()
            1 -> LiveFragment()
            2 -> MeFragment()
            else -> Fragment()
        }
    }
}