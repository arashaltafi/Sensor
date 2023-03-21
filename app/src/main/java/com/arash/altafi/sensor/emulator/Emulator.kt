package com.arash.altafi.sensor.emulator

import android.content.Context
import android.os.Build
import androidx.annotation.Keep
import java.io.File
import java.util.*
import com.nekolaboratory.EmulatorDetector
import com.snail.antifake.jni.EmulatorDetectUtil

@Keep
object Emulator {

    private fun isEmulator1(): Boolean {
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")
                || Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.contains("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.HARDWARE.contains("goldfish")
                || Build.HARDWARE.contains("ranchu")
                || Build.HARDWARE == "vbox86"
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.PRODUCT.contains("sdk_google")
                || Build.PRODUCT.contains("google_sdk")
                || Build.PRODUCT.contains("sdk")
                || Build.PRODUCT.contains("sdk_x86")
                || Build.PRODUCT.contains("sdk_gphone64_arm64")
                || Build.PRODUCT.contains("vbox86p")
                || Build.PRODUCT.contains("emulator")
                || Build.PRODUCT.contains("simulator"))
                || Build.PRODUCT == "sdk_google_phone_x86"
    }

    private fun isEmulator2(): Boolean {
        // Android SDK emulator
        return (Build.FINGERPRINT.startsWith("google/sdk_gphone_")
                && Build.FINGERPRINT.endsWith(":user/release-keys")
                && Build.MANUFACTURER == "Google" && Build.PRODUCT.startsWith("sdk_gphone_") && Build.BRAND == "google"
                && Build.MODEL.startsWith("sdk_gphone_"))
                //bluestacks
                || "QC_Reference_Phone" == Build.BOARD && !"Xiaomi".equals(Build.MANUFACTURER, ignoreCase = true) //bluestacks
                || Build.HOST=="Build2" //MSI App Player
                || Build.PRODUCT == "google_sdk"
                // another Android SDK emulator check
                ||  SystemProperties.getProp("ro.kernel.qemu") == "1"
                //
                || Build.HARDWARE.lowercase(Locale.getDefault()).contains("nox")
                || Build.MODEL.lowercase(Locale.getDefault()).contains("droid4x")
                || Build.PRODUCT.lowercase(Locale.getDefault()).contains("nox")
                || Build.BOARD.lowercase(Locale.getDefault()).contains("nox")
                || Build.BOOTLOADER.lowercase(Locale.getDefault()).contains("nox")
                || Build.SERIAL.lowercase(Locale.getDefault()).contains("nox")
    }

    private fun isEmulator3():Boolean {
        return (checkFiles(GENY_FILES)
                || checkFiles(ANDY_FILES)
                || checkFiles(NOX_FILES)
                || checkFiles(X86_FILES)
                || checkFiles(PIPES))
    }
    private val GENY_FILES = arrayOf(
        "/dev/socket/genyd",
        "/dev/socket/baseband_genyd"
    )
    private val PIPES = arrayOf(
        "/dev/socket/qemud",
        "/dev/qemu_pipe"
    )
    private val X86_FILES = arrayOf(
        "ueventd.android_x86.rc",
        "x86.prop",
        "ueventd.ttVM_x86.rc",
        "init.ttVM_x86.rc",
        "fstab.ttVM_x86",
        "fstab.vbox86",
        "init.vbox86.rc",
        "ueventd.vbox86.rc"
    )
    private val ANDY_FILES = arrayOf(
        "fstab.andy",
        "ueventd.andy.rc"
    )
    private val NOX_FILES = arrayOf(
        "fstab.nox",
        "init.nox.rc",
        "ueventd.nox.rc"
    )

    private fun checkFiles(targets: Array<String>): Boolean {
        for (pipe in targets) {
            val file = File(pipe)
            if (file.exists()) {
                return true
            }
        }
        return false
    }

    fun isEmulator(context: Context): Boolean {
        return EmulatorDetector.isEmulator(context) || EmulatorDetectUtil.isEmulator(context) || isEmulator1() || isEmulator2() || isEmulator3()
    }

}