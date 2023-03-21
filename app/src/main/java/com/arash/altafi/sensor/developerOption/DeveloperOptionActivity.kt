package com.arash.altafi.sensor.developerOption

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.emulator.popError
import com.arash.altafi.sensor.emulator.popSuccess
import kotlinx.android.synthetic.main.activity_developer_option.*

class DeveloperOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_option)

        init()
    }

    private fun init() {
        btnCheckDeveloperOption.setOnClickListener {
            if (isDevMode(this)) {
                popError("Developer Option is Active!!!")
            } else {
                popSuccess("Developer Option is Not Active!!!")
            }
        }

        btnGoToDeveloperOption.setOnClickListener {
            startActivity(Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS))
        }
    }

    private fun isDevMode(context: Context): Boolean =
        Settings.Secure.getInt(
            context.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
            0
        ) != 0

}