package com.arash.altafi.sensor.deviceInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_device_info.*

class DeviceInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_info)

        init()
    }

    private fun init() {
        btnGetAndroidID.setOnClickListener {
            val deviceAndroidID = DeviceInfo.getAndroidID(this)
            tvDeviceInformation.text = deviceAndroidID
        }
        btnGetDeviceAndroidVersion.setOnClickListener {
            val deviceAndroidVersion = DeviceInfo.getDeviceAndroidVersion()
            tvDeviceInformation.text = deviceAndroidVersion
        }
        btnGetDeviceModel.setOnClickListener {
            val deviceModel = DeviceInfo.getDeviceModel()
            tvDeviceInformation.text = deviceModel
        }
        btnGetDeviceManufacturer.setOnClickListener {
            val deviceManufacturer = DeviceInfo.getDeviceManufacturer()
            tvDeviceInformation.text = deviceManufacturer
        }
        btnGetOperatorName.setOnClickListener {
            val deviceOperatorName = DeviceInfo.getOperatorName(this)
            tvDeviceInformation.text = deviceOperatorName
        }
        btnGetGmail.setOnClickListener {
            val deviceGmail = DeviceInfo.getGmail(this)
            tvDeviceInformation.text = deviceGmail
        }
        btnGetScreenDimension.setOnClickListener {
            val deviceScreenDimension = DeviceInfo.getScreenDimension(this)
            tvDeviceInformation.text = deviceScreenDimension
        }
        btnGetUnique.setOnClickListener {
            val deviceUnique =
                "${DeviceInfo.getDeviceManufacturer()} ${DeviceInfo.getDeviceModel()} - Android ${DeviceInfo.getDeviceAndroidVersion()} - ${
                    DeviceInfo.getAndroidID(this)
                }"
            tvDeviceInformation.text = deviceUnique
        }
    }

}