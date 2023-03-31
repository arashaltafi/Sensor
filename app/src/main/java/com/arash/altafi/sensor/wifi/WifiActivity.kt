package com.arash.altafi.sensor.wifi

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_wifi.*

class WifiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)

        init()
    }

    private fun init() {
        btnManageWifi.setOnClickListener {
            startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
        }
    }

}