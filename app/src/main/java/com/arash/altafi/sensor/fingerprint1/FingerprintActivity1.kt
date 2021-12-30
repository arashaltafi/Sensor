package com.arash.altafi.sensor.fingerprint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.sensor.R
import android.widget.Toast
import android.content.DialogInterface
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.marcoscg.fingerauth.FingerAuth
import com.marcoscg.fingerauth.FingerAuthDialog
import kotlinx.android.synthetic.main.activity_fingerprint.*

class FingerprintActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint)

        val hasFingerprintSupport = FingerAuth.hasFingerprintSupport(this)
        if (hasFingerprintSupport) {
            init()
        } else {
            Toast.makeText(this , "گوشی شما قابلیت اثر انگشت ندارد" , Toast.LENGTH_SHORT).show()
        }

    }

    private fun init() {

        FingerAuthDialog(this)
            .setTitle("Sign in")
            .setCancelable(false)
            .setMaxFailedCount(3) // Number of attemps, default 3
            .setPositiveButton("Use password", DialogInterface.OnClickListener { dialogInterface, i ->
                    // do something
                })
            .setOnFingerAuthListener(object : FingerAuth.OnFingerAuthListener {
                override fun onSuccess() {
                    Toast.makeText(this@FingerprintActivity1, "Successfully", Toast.LENGTH_SHORT).show()
                    icon.setColorFilter(ContextCompat.getColor(this@FingerprintActivity1, R.color.green),
                        android.graphics.PorterDuff.Mode.SRC_IN)
                    finger_print.text = "Successfully"
                    finger_print.setTextColor(Color.GREEN)
                }

                override fun onFailure() {
                    Toast.makeText(this@FingerprintActivity1, "Failure", Toast.LENGTH_SHORT).show()
                    icon.setColorFilter(ContextCompat.getColor(this@FingerprintActivity1, R.color.red),
                        android.graphics.PorterDuff.Mode.SRC_IN)
                }

                override fun onError() {
                    Toast.makeText(this@FingerprintActivity1, "Error", Toast.LENGTH_SHORT).show()
                    finger_print.text = "Error"
                    finger_print.setTextColor(Color.RED)
                }
            })
            .show()

    }

}