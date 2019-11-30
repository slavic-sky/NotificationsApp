package com.example.notificationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.findNavController
import androidx.navigation.plusAssign
import androidx.viewpager.widget.ViewPager
import com.example.notificationapp.databinding.ActivityMainBinding
import com.example.notificationapp.view.adapters.CustomFragmentPagerAdapter
import com.example.notificationapp.view.fragments.InputFragment
import com.example.notificationapp.view.fragments.ListPostsFragment
import com.example.notificationapp.view.navigation.KeepStateNavigator
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout
    private lateinit var inputFragment: InputFragment
    private lateinit var listPostsFragment: ListPostsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        initViews()
        setupViewPager()

        val navController = findNavController(R.id.nav_host_fragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, R.id.nav_host_fragment)
        navController.navigatorProvider += navigator

        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(navController.graph.startDestination, false)
            .build()

        val tabLayout = tabs

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        navController.navigate(R.id.navigation_input, null, navOptions)
                    }
                    1 -> navController.navigate(R.id.navigation_list, null, navOptions)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs)
        viewPager = pager as ViewPager
    }

    private fun setupViewPager() {
        val adapter = CustomFragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        inputFragment = InputFragment.newInstance(0, "Input post") as InputFragment
        listPostsFragment = ListPostsFragment.newInstance(1, "List of messages") as ListPostsFragment
        adapter.addFragment(inputFragment, "Input post")
        adapter.addFragment(listPostsFragment, "List of messages")
        tabs.setupWithViewPager(viewPager)
    }

}


