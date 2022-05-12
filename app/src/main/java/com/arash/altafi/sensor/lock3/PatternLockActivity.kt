package com.arash.altafi.sensor.lock3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.toast
import com.itsxtt.patternlock.PatternLockView
import kotlinx.android.synthetic.main.activity_pattern_9x9.*
import kotlinx.android.synthetic.main.activity_pattern_default.*
import kotlinx.android.synthetic.main.activity_pattern_jd.*
import kotlinx.android.synthetic.main.activity_pattern_with_indicator.*
import java.util.ArrayList

class PatternLockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when(intent.getIntExtra(Lock3Activity.KEY_PATTERN_TYPE, Lock3Activity.TYPE_DEFAULT)) {
            Lock3Activity.TYPE_DEFAULT -> {
                setContentView(R.layout.activity_pattern_default)
                defaultPatternLockView.setOnPatternListener(listener)
            }
            Lock3Activity.TYPE_JD_STYLE -> {
                setContentView(R.layout.activity_pattern_jd)
                jdPatternLockView.setOnPatternListener(listener)
            }
            Lock3Activity.TYPE_WITH_INDICATOR -> {
                setContentView(R.layout.activity_pattern_with_indicator)
                indicatorPatternLockView.setOnPatternListener(listener)
            }
            Lock3Activity.TYPE_9x9 -> {
                setContentView(R.layout.activity_pattern_9x9)
                ninePatternLockView.setOnPatternListener(listener)
            }
            Lock3Activity.TYPE_SECURE_MODE -> {
                setContentView(R.layout.activity_pattern_default)
                defaultPatternLockView.enableSecureMode()
                defaultPatternLockView.setOnPatternListener(listener)
            }
        }

    }

    private var listener  = object : PatternLockView.OnPatternListener {

        override fun onStarted() {
            super.onStarted()
            Log.i("test123321", "onStarted:")
        }

        override fun onProgress(ids: ArrayList<Int>) {
            super.onProgress(ids)
            Log.i("test123321", "onProgress: $ids")
        }

        override fun onComplete(ids: ArrayList<Int>): Boolean {
            Log.i("test123321", "onComplete: $ids")
            val isCorrect = TextUtils.equals("012", getPatternString(ids))
            val tip: String = if (isCorrect) {
                "correct:" + getPatternString(ids)
            } else {
                "error:" + getPatternString(ids)
            }
            Toast.makeText(this@PatternLockActivity, tip, Toast.LENGTH_SHORT).show()
            return isCorrect
        }
    }

    private fun getPatternString(ids: ArrayList<Int>) : String {
        var result = ""
        for (id in ids) {
            result += id.toString()
        }
        return result
    }
}