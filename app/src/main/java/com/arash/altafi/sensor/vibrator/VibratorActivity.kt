package com.arash.altafi.sensor.vibrator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_vibrator.*

class VibratorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrator)

        init()
    }

    private fun init() {
        btn_vibrator_1.setOnClickListener {
            if (VibratorUtils.canVibrate(this)) {
                VibratorUtils.vibrate(this)
            } else {
                Toast.makeText(this, "your device has not support vibrator", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}