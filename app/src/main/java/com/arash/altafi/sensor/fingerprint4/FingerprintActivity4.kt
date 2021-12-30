package com.arash.altafi.sensor.fingerprint4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import com.arash.altafi.sensor.R
import com.easyfingerprint.EasyFingerPrint
import kotlinx.android.synthetic.main.activity_fingerprint4.*

class FingerprintActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint4)

        init()
    }

    private fun init() {

        btn_finger_4.setOnClickListener {
            EasyFingerPrint(this)
                .setTittle("Sign in")
                .setSubTittle("account@account.com.br")
                .setDescription("In order to use the Fingerprint sensor we need your authorization first.e")
                .setColorPrimary(R.color.colorPrimary)
                .setIcon(ContextCompat.getDrawable(this,R.mipmap.ic_launcher_round))
                .setListern(object : EasyFingerPrint.ResultFingerPrintListern{
                    override fun onError(mensage: String, code: Int) {

                        when(code){
                            EasyFingerPrint.CODE_ERRO_CANCEL -> { } // TO DO
                            EasyFingerPrint.CODE_ERRO_GREATER_ANDROID_M -> { } // TO DO
                            EasyFingerPrint.CODE_ERRO_HARDWARE_NOT_SUPPORTED -> { } // TO DO
                            EasyFingerPrint.CODE_ERRO_NOT_ABLED -> { } // TO DO
                            EasyFingerPrint.CODE_ERRO_NOT_FINGERS -> { } // TO DO
                            EasyFingerPrint.CODE_NOT_PERMISSION_BIOMETRIC -> { } // TO DO
                        }

                        Toast.makeText(this@FingerprintActivity4,"Error: $mensage / $code", Toast.LENGTH_SHORT).show()
                    }

                    override fun onSucess(cryptoObject: FingerprintManagerCompat.CryptoObject?) {
                        Toast.makeText(this@FingerprintActivity4,"Success", Toast.LENGTH_SHORT).show()
                    }

                })
                .startScan()
        }

    }

}