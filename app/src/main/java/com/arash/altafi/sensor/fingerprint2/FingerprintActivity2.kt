package com.arash.altafi.sensor.fingerprint2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.arash.altafi.sensor.R
import com.arash.altafi.sensor.fingerprint2.helper.AuthenticationError
import com.arash.altafi.sensor.fingerprint2.helper.navigateTo
import kotlinx.android.synthetic.main.activity_fingerprint2.*

class FingerprintActivity2 : AppCompatActivity() {

    private lateinit var biometricPrompt : BiometricPrompt
    private lateinit var biometricManager: BiometricManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint2)

        setupBiometricAuthentication()
        checkBiometricFeatureState()

        ivAuthenticate.setOnClickListener {
            if (isBiometricFeatureAvailable()) {
                biometricPrompt.authenticate(buildBiometricPrompt())
            }
        }

    }

    private fun setupBiometricAuthentication() {
        biometricManager = BiometricManager.from(this)
        val executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor, biometricCallback)
    }

    private fun checkBiometricFeatureState() {
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> setErrorNotice("Sorry. It seems your device has no biometric hardware")
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> setErrorNotice("Biometric features are currently unavailable.")
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> setErrorNotice("You have not registered any biometric credentials")
            BiometricManager.BIOMETRIC_SUCCESS -> {}
        }
    }

    private fun buildBiometricPrompt(): BiometricPrompt.PromptInfo {
        return BiometricPrompt.PromptInfo.Builder()
            .setTitle("Verify your identity")
            .setDescription("Confirm your identity so we can verify it's you")
            .setNegativeButtonText("Cancel")
            .setConfirmationRequired(false) //Allows user to authenticate without performing an action, such as pressing a button, after their biometric credential is accepted.
            .build()
    }

    private fun isBiometricFeatureAvailable(): Boolean {
        return biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS
    }

    private val biometricCallback = object : BiometricPrompt.AuthenticationCallback() {
        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
            super.onAuthenticationSucceeded(result)
            navigateTo<HomeActivity>()
        }

        override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
            super.onAuthenticationError(errorCode, errString)

            if (errorCode != AuthenticationError.AUTHENTICATION_DIALOG_DISMISSED.errorCode && errorCode != AuthenticationError.CANCELLED.errorCode) {
                setErrorNotice(errString.toString())
            }
        }
    }

    private fun setErrorNotice(errorMessage: String) {
        tvErrorNotice.text = errorMessage
    }

}