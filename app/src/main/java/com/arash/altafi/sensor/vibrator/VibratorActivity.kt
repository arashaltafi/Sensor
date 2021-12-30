package com.arash.altafi.sensor.vibrator

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
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
            canVibrate()
        }
    }

    private fun canVibrate() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // your device has support vibrator???
        if(vibrator.hasVibrator()) {
            vibrate(1000)
        }
        else {
            Toast.makeText(this , "your device has not support vibrator" , Toast.LENGTH_SHORT).show()
        }

    }

    private fun vibrate(millisecond: Long) {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(millisecond, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(millisecond)
        }
    }

}