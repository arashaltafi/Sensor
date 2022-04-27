package com.arash.altafi.sensor.flash1

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_flash1.*

class FlashActivity1 : AppCompatActivity() {

    private lateinit var cameraM : CameraManager
    var isFlash = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash1)

        init()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun init() {
        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        btn_flash.setOnClickListener {
            if(!isFlash){
                val cameraListId = cameraM.cameraIdList[0]
                cameraM.setTorchMode(cameraListId, true)
                isFlash = true
                btn_flash.setImageResource(R.drawable.power_on)
            }
            else{
                val cameraListId = cameraM.cameraIdList[0]
                cameraM.setTorchMode(cameraListId, false)
                isFlash = false
                btn_flash.setImageResource(R.drawable.power_off)
            }
        }
    }

}