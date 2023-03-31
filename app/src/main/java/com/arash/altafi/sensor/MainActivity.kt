package com.arash.altafi.sensor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.Shake.SeismicActivity
import com.arash.altafi.sensor.developerOption.DeveloperOptionActivity
import com.arash.altafi.sensor.deviceInfo.DeviceInfoActivity
import com.arash.altafi.sensor.emulator.EmulatorActivity
import com.arash.altafi.sensor.fingerprint1.FingerprintActivity1
import com.arash.altafi.sensor.fingerprint2.FingerprintActivity2
import com.arash.altafi.sensor.fingerprint3.FingerprintActivity3
import com.arash.altafi.sensor.fingerprint4.FingerprintActivity4
import com.arash.altafi.sensor.flash1.FlashActivity1
import com.arash.altafi.sensor.lock1.Lock1Activity
import com.arash.altafi.sensor.lock2.Lock2Activity
import com.arash.altafi.sensor.lock3.Lock3Activity
import com.arash.altafi.sensor.restartApp.RestartAppActivity
import com.arash.altafi.sensor.root.CheckRootActivity
import com.arash.altafi.sensor.screenShot.ScreenShotActivity
import com.arash.altafi.sensor.vibrator.VibratorActivity
import com.arash.altafi.sensor.wifi.WifiActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btn_vibrator.setOnClickListener {
            startActivity(Intent(this, VibratorActivity::class.java))
        }

        btn_shake.setOnClickListener {
            startActivity(Intent(this, SeismicActivity::class.java))
        }

        btn_finger_print_1.setOnClickListener {
            startActivity(Intent(this, FingerprintActivity1::class.java))
        }

        btn_finger_print_2.setOnClickListener {
            startActivity(Intent(this, FingerprintActivity2::class.java))
        }

        btn_finger_print_3.setOnClickListener {
            startActivity(Intent(this, FingerprintActivity3::class.java))
        }

        btn_finger_print_4.setOnClickListener {
            startActivity(Intent(this, FingerprintActivity4::class.java))
        }

        btn_flash_1.setOnClickListener {
            startActivity(Intent(this, FlashActivity1::class.java))
        }

        btn_lock_1.setOnClickListener {
            startActivity(Intent(this, Lock1Activity::class.java))
        }

        btn_lock_2.setOnClickListener {
            startActivity(Intent(this, Lock2Activity::class.java))
        }

        btn_lock_3.setOnClickListener {
            startActivity(Intent(this, Lock3Activity::class.java))
        }

        btn_screen_shot.setOnClickListener {
            startActivity(Intent(this, ScreenShotActivity::class.java))
        }

        btn_restart_app.setOnClickListener {
            startActivity(Intent(this, RestartAppActivity::class.java))
        }

        btn_check_emulator.setOnClickListener {
            startActivity(Intent(this, EmulatorActivity::class.java))
        }

        btn_check_developer_option.setOnClickListener {
            startActivity(Intent(this, DeveloperOptionActivity::class.java))
        }

        btn_check_root.setOnClickListener {
            startActivity(Intent(this, CheckRootActivity::class.java))
        }

        btn_device_info.setOnClickListener {
            startActivity(Intent(this, DeviceInfoActivity::class.java))
        }

        btn_manage_wifi.setOnClickListener {
            startActivity(Intent(this, WifiActivity::class.java))
        }
    }

}