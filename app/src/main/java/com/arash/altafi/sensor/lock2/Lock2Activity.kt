package com.arash.altafi.sensor.lock2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.toast
import com.itsxtt.patternlock.PatternLockView
import kotlinx.android.synthetic.main.activity_lock2.*

class Lock2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock2)

        init()
    }

    private fun init() {
        patternLockView.setOnPatternListener(object : PatternLockView.OnPatternListener {
            override fun onStarted() {
                super.onStarted()
                toast("onStarted")
            }

            override fun onProgress(ids: ArrayList<Int>) {
                super.onProgress(ids)
                toast("onProgress")
                Log.i("test123321", "onProgress: $ids")
            }

            override fun onComplete(ids: ArrayList<Int>): Boolean {
                toast("onComplete")
                Log.i("test123321", "onComplete: $ids")
                /*
                 * A return value required
                 * if the pattern is not correct and you'd like change the pattern to error state, return false
                 * otherwise return true
                 */
                return true
            }
        })
    }

}