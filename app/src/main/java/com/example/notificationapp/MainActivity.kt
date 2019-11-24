package com.example.notificationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.notificationapp.view.adapters.CustomFragmentPagerAdapter
import com.example.notificationapp.view.fragments.InputFragment
import com.example.notificationapp.view.fragments.ListPostsFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setupViewPager()
    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs)
        viewPager = pager as ViewPager
    }

    private fun setupViewPager() {
        val adapter = CustomFragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        val inputFragment = InputFragment.newInstance(0, "Input post")
        val listPostsFragment = ListPostsFragment.newInstance(1, "List of messages")
        adapter.addFragment(inputFragment, "Input post")
        adapter.addFragment(listPostsFragment, "List of messages")

        tabs.setupWithViewPager(viewPager)
    }

}


