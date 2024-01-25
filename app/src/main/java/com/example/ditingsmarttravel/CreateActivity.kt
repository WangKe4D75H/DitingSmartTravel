package com.example.ditingsmarttravel

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.icon_left_arrow)
        setSupportActionBar(toolbar)
        val upArrow: Drawable? = ContextCompat.getDrawable(applicationContext,
            R.drawable.icon_left_arrow)
        upArrow?.setColorFilter(ContextCompat.getColor(applicationContext, R.color.ditingBlue),
            PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragmentList = listOf(CreateTripFragment(), CreateScheduleFragment(), CreateTodoFragment())
        private val fragmentTitleList = listOf("行程", "日程", "待办")

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList[position]
        }
    }
}