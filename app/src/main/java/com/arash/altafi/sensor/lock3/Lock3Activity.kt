package com.arash.altafi.sensor.lock3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.R
import kotlinx.android.synthetic.main.activity_lock3.*

class Lock3Activity : AppCompatActivity() {

    companion object {
        const val KEY_PATTERN_TYPE = "type"

        const val TYPE_DEFAULT = 0
        const val TYPE_WITH_INDICATOR = 1
        const val TYPE_JD_STYLE = 2
        const val TYPE_9x9 = 3
        const val TYPE_SECURE_MODE = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock3)

        init()
    }

    private fun init() {
        defaultBtn.setOnClickListener { startPatternActivity(TYPE_DEFAULT) }
        jdStyleBtn.setOnClickListener { startPatternActivity(TYPE_JD_STYLE) }
        indicatorBtn.setOnClickListener { startPatternActivity(TYPE_WITH_INDICATOR) }
        nineBtn.setOnClickListener { startPatternActivity(TYPE_9x9) }
        secureModeBtn.setOnClickListener { startPatternActivity(TYPE_SECURE_MODE) }
    }

    private fun startPatternActivity(type: Int) {
        val intent = Intent(this, PatternLockActivity::class.java)
        intent.putExtra(KEY_PATTERN_TYPE, type)
        startActivity(intent)
    }

}