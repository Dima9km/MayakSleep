package com.dima.mayaksleep.ui.screens.radio

import android.app.Application
import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.dima.mayaksleep.MyPlayer

class RadioViewModel(application: Application) : AndroidViewModel(application) {

    private var player = MyPlayer(application)
    var liveDataText = MutableLiveData<String>()
    var liveDataStatus = MutableLiveData<Boolean>()
    private lateinit var timer: CountDownTimer

    fun startDevice(hour: Long, minute: Long) {
        var minute = minute
        if (hour == 0L && minute == 0L) {
            minute = 30L
        }

        timer = object : CountDownTimer((3600000 * hour) + (minute * 60000), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                liveDataText.value = String.format(
                    "%s осталось", DateUtils
                        .formatElapsedTime(millisUntilFinished / 1000)
                )
            }

            override fun onFinish() {
                stopDevice()
            }
        }.start()
        liveDataStatus.value = true
        player.play()
    }

    fun stopDevice() {
        player.stop()
        liveDataText.value = ""
        liveDataStatus.value = false
        timer.cancel()
    }
}