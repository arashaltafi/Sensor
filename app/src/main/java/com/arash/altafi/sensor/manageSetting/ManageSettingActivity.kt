package com.arash.altafi.sensor.manageSetting

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.toast
import kotlinx.android.synthetic.main.activity_manage_setting.*

class ManageSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_setting)

        init()
    }

    private fun init() {
        btnManageWifi.setOnClickListener {
            startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
        }

        btnManageBluetooth.setOnClickListener {
            startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS))
        }

        btnManageSetting.setOnClickListener {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }

        btnManageGPS.setOnClickListener {
            if (GpsUtils.isDisabledGps(this)) {
                GpsUtils.enableGps(this)
            } else {
                toast("Gps is Enable")
            }
        }
    }

}