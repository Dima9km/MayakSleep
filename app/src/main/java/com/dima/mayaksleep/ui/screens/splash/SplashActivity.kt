package com.dima.mayaksleep.ui.screens.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dima.mayaksleep.R
import com.dima.mayaksleep.ui.screens.main.MainActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timer("pause", false).schedule(3000) {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }



}