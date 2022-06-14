package com.example.limify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.limify.fragments.AccountFragment
import com.example.limify.fragments.CalendarFragment
import com.example.limify.fragments.HomeFragment
import com.example.limify.fragments.InputFragment
import com.example.limify01.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val inputFragment = InputFragment()
        val calendarFragment = CalendarFragment()
        val accountFragment = AccountFragment()
        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        makeCurrentFragment(homeFragment)

        bottomnavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.input -> makeCurrentFragment(inputFragment)
                R.id.calendar -> makeCurrentFragment(calendarFragment)
                R.id.account -> makeCurrentFragment(accountFragment)
            }

            return@setOnItemSelectedListener true
        }
    }



private fun makeCurrentFragment(fragment: Fragment) =
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()

    }

}