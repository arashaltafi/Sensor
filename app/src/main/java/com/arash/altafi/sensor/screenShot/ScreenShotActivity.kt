package com.arash.altafi.sensor.screenShot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.toast
import kotlinx.android.synthetic.main.activity_screen_shot.*

class ScreenShotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_shot)

        init()
    }

    private fun init() {
        btnDisableTakeScreenShot.setOnClickListener {
            disableTakeScreenShot()
            toast("disable take screen shot with android system device")
        }

        btnEnableTakeScreenShot.setOnClickListener {
            enableTakeScreenShot()
            toast("enable take screen shot with android system device")
        }

        btnTakeScreenShot.setOnClickListener {
            takeScreenShot(clRoot)
        }
    }

}