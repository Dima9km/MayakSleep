package com.dima.mayaksleep.ui.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dima.mayaksleep.R
import com.dima.mayaksleep.ui.screens.alarm.AlarmFragment
import com.dima.mayaksleep.ui.screens.sleepradio.SleepRadioFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sleepRadioFragment = SleepRadioFragment()
        val alarmFragment = AlarmFragment()
        changeFragment(alarmFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnv)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.naviSleepRadio -> {
                    changeFragment(sleepRadioFragment)
                }
                R.id.naviAlarm -> {
                    changeFragment(alarmFragment)
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