package com.darshan.creditapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.darshan.creditapp.fragments.HistoryFragment
import com.darshan.creditapp.fragments.HomeFragment
import com.darshan.creditapp.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    private val navBarListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                toolbar.title = "Credit App"
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
                toolbar.title = "History"
                val historyFragment = HistoryFragment.newInstance()
                openFragment(historyFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                toolbar.title = "Profile"
                val profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!

        val navBar: BottomNavigationView = findViewById(R.id.nav_bar)

        // Initailize with home frag
        val homeFragment = HomeFragment.newInstance()
        openFragment(homeFragment)

        navBar.setOnNavigationItemSelectedListener(navBarListener)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
            .commit()
    }
}
