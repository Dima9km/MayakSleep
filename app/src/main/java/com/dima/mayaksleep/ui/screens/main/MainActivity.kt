package com.dima.mayaksleep.ui.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dima.mayaksleep.R
import com.dima.mayaksleep.ui.screens.radio.RadioFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioFragment = RadioFragment()
        changeFragment(radioFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnv)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.naviRadio -> {
                    changeFragment(radioFragment)
                }
                R.id.naviNews -> {
                    changeFragment(radioFragment)
                }
                R.id.naviPics -> {
                    changeFragment(radioFragment)
                }
            }
            true
        }

    }

    private fun changeFragment(toChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragmentContainer, toChange).commit()
    }

}