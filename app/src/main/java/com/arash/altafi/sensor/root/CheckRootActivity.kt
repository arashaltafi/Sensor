package com.arash.altafi.sensor.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.emulator.popError
import com.arash.altafi.sensor.emulator.popSuccess
import kotlinx.android.synthetic.main.activity_check_root.*

class CheckRootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_root)

        init()
    }

    private fun init() {
        btnCheckRoot.setOnClickListener {
            if (CheckRootUtils.isDeviceRooted()) {
                popError("Device is Root!!!")
            } else {
                popSuccess("Device is Not Root!!!")
            }
        }
    }

}