package com.arash.altafi.sensor.emulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_emulator.*

class EmulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emulator)

        init()
    }

    private fun init() {
        btnCheckEmulator.setOnClickListener {
            Emulator.isEmulator(this).apply {
                if (this) {
                    popError("Device is Emulator!!!")
                } else {
                    popSuccess("Device is Not Emulator!!!")
                }
            }
        }
    }

}