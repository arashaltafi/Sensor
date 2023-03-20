package com.arash.altafi.sensor.vibrator

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

object VibratorUtils {

    fun vibrate(context: Context, time: Long = 500) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val vibrator = context.getSystemService(Vibrator::class.java)
            val pattern = longArrayOf(0, 0, 0, 500, 500)
            val effect = VibrationEffect.createWaveform(pattern, -1)
            vibrator.vibrate(effect)
        } else {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(time)
        }
    }

    /**
     * your device has support vibrator???
     */
    fun canVibrate(context: Context): Boolean {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.getSystemService(Vibrator::class.java)
        } else {
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
        return vibrator.hasVibrator()
    }

}