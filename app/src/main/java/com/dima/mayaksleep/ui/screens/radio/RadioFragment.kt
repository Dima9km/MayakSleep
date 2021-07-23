package com.dima.mayaksleep.ui.screens.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dima.mayaksleep.R

class RadioFragment : Fragment() {

    private lateinit var radioViewModel: RadioViewModel

    private lateinit var tvRemainingTime: TextView
    private lateinit var tpTime: TimePicker
    private lateinit var btnStartStop: Button
    private var isRadioOn: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        radioViewModel = ViewModelProvider(this).get(RadioViewModel::class.java)

        initUI()

        initLiveData()
    }

    override fun onResume() {
        super.onResume()

        btnStartStop.setOnClickListener {
            if (!isRadioOn) {
                radioViewModel.startDevice(tpTime.hour.toLong(), tpTime.minute.toLong())
                btnStartStop.text = "Stop"
                tpTime.setVisibility(View.GONE)
            } else {
                radioViewModel.stopDevice()
                btnStartStop.text = "Start"
                tpTime.setVisibility(View.VISIBLE)
            }
        }
    }

    private fun initUI() {
        tvRemainingTime = requireView().findViewById(R.id.tvRemainingTime)

        tpTime = requireView().findViewById(R.id.tpTime)
        tpTime.setIs24HourView(true)
        tpTime.hour = 0
        tpTime.minute = 30

        btnStartStop = requireView().findViewById<Button>(R.id.btnStartStop)
    }

    private fun initLiveData() {
        radioViewModel.liveDataText.observe(viewLifecycleOwner, Observer {
            tvRemainingTime.text = it
        })
        radioViewModel.liveDataStatus.observe(viewLifecycleOwner, Observer {
            isRadioOn = it
        })
    }
}