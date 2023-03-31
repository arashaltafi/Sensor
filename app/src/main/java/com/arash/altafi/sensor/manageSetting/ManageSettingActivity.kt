package com.arash.altafi.sensor.manageSetting

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.toast
import kotlinx.android.synthetic.main.activity_manage_setting.*

class ManageSettingActivity : AppCompatActivity() {

    private val gpsSwitchStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (LocationManager.PROVIDERS_CHANGED_ACTION == intent.action) {
                if (GpsUtils.isDisabledGps(this@ManageSettingActivity).not()) {
                    toast("gps is on")
                } else {
                    toast("gps is off")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_setting)

        registerReceiver()
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

    private fun unregisterReceiver() = unregisterReceiver(gpsSwitchStateReceiver)

    private fun registerReceiver() {
        val filter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        filter.addAction(Intent.ACTION_PROVIDER_CHANGED)
        registerReceiver(gpsSwitchStateReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver()
    }

}