package com.arash.altafi.sensor.lock1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andrognito.patternlockview.PatternLockView
import com.andrognito.patternlockview.listener.PatternLockViewListener
import com.andrognito.patternlockview.utils.PatternLockUtils
import com.andrognito.patternlockview.utils.ResourceUtils
import com.andrognito.rxpatternlockview.RxPatternLockView
import com.andrognito.rxpatternlockview.events.PatternLockCompoundEvent
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.toast
import kotlinx.android.synthetic.main.activity_lock1.*


class Lock1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock1)

        init()
    }

    @SuppressLint("CheckResult")
    private fun init() {
        pattern_lock_view_1.addPatternLockListener(object: PatternLockViewListener {
            override fun onStarted() {
                toast("onStarted")
            }
            override fun onProgress(progressPattern: MutableList<PatternLockView.Dot>?) {
                toast("onProgress")
                toast(PatternLockUtils.patternToString(pattern_lock_view_1, progressPattern))
            }
            override fun onComplete(pattern: MutableList<PatternLockView.Dot>?) {
                toast("onComplete")
                toast(PatternLockUtils.patternToString(pattern_lock_view_1, pattern))
            }
            override fun onCleared() {
                toast("onCleared")
            }
        })

        RxPatternLockView.patternChanges(pattern_lock_view_1).subscribe {
                when (it.eventType) {
                    PatternLockCompoundEvent.EventType.PATTERN_STARTED -> {

                    }
                    PatternLockCompoundEvent.EventType.PATTERN_PROGRESS -> {

                    }
                    PatternLockCompoundEvent.EventType.PATTERN_COMPLETE -> {

                    }
                    PatternLockCompoundEvent.EventType.PATTERN_CLEARED -> {

                    }
                }
            }

        pattern_lock_view_1.dotCount = 3
        pattern_lock_view_1.dotNormalSize = ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_size).toInt()
        pattern_lock_view_1.dotSelectedSize = ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_selected_size).toInt()
        pattern_lock_view_1.pathWidth = ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_path_width).toInt()
        pattern_lock_view_1.isAspectRatioEnabled = true
        pattern_lock_view_1.aspectRatio = PatternLockView.AspectRatio.ASPECT_RATIO_HEIGHT_BIAS
        pattern_lock_view_1.setViewMode(PatternLockView.PatternViewMode.CORRECT)
        pattern_lock_view_1.dotAnimationDuration = 150
        pattern_lock_view_1.pathEndAnimationDuration = 100
        pattern_lock_view_1.normalStateColor = ResourceUtils.getColor(this, R.color.black)
        pattern_lock_view_1.correctStateColor = ResourceUtils.getColor(this, R.color.colorPrimary)
        pattern_lock_view_1.wrongStateColor = ResourceUtils.getColor(this, R.color.pomegranate)
        pattern_lock_view_1.correctStateColor = ResourceUtils.getColor(this, R.color.red)
        pattern_lock_view_1.isInStealthMode = false
        pattern_lock_view_1.isTactileFeedbackEnabled = true
        pattern_lock_view_1.isInputEnabled = true

//        pattern_lock_view_1.setViewMode(PatternLockView.PatternViewMode.CORRECT) // Set the current view more
//        pattern_lock_view_1.isInStealthMode = true          // Set the pattern in stealth mode (pattern drawing is hidden)
//        pattern_lock_view_1.isTactileFeedbackEnabled = true // Enables vibration feedback when the pattern is drawn
//        pattern_lock_view_1.isInputEnabled = false          // Disables any input from the pattern lock view completely
//        pattern_lock_view_1.dotCount = 3
//        pattern_lock_view_1.dotNormalSize = ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_size).toInt()
//        pattern_lock_view_1.dotSelectedSize = ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_selected_size).toInt()
//        pattern_lock_view_1.pathWidth = ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_path_width).toInt()
//        pattern_lock_view_1.isAspectRatioEnabled = true
//        pattern_lock_view_1.aspectRatio = PatternLockView.AspectRatio.ASPECT_RATIO_HEIGHT_BIAS
//        pattern_lock_view_1.normalStateColor = ResourceUtils.getColor(this, R.color.black)
//        pattern_lock_view_1.correctStateColor = ResourceUtils.getColor(this, R.color.colorPrimary)
//        pattern_lock_view_1.wrongStateColor = ResourceUtils.getColor(this, R.color.pomegranate)
//        pattern_lock_view_1.dotAnimationDuration = 150
//        pattern_lock_view_1.pathEndAnimationDuration = 100

    }

}