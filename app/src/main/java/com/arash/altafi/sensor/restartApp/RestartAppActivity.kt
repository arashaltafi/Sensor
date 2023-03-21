package com.arash.altafi.sensor.restartApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.MainActivity
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_restart_app.*

class RestartAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart_app)

        init()
    }

    private fun init() {
        btnRestartApp.setOnClickListener {
            restartApp(MainActivity::class.java)
        }
    }

}