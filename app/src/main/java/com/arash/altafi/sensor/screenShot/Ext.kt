package com.arash.altafi.sensor.screenShot

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import android.os.StrictMode
import android.view.View
import android.view.WindowManager
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

fun Context.takeScreenShot(
    root: View
) {
    root.post {
        val bitmap = Bitmap.createBitmap(
            root.width,
            root.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        root.draw(canvas)

        shareImage(packageName, bitmap)
    }
}

private fun Context.shareImage(
    applicationId: String,
    bitmap: Bitmap,
    body: String = "",
    title: String = "",
    subject: String = ""
) {
    val file = File(externalCacheDir, System.currentTimeMillis().toString() + ".jpg")
    val out = FileOutputStream(file)
    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
    out.close()
    val bmpUri = if (Build.VERSION.SDK_INT < 24) {
        Uri.fromFile(file)
    } else {
        FileProvider.getUriForFile(
            this, "$applicationId.fileprovider", file
        )
    }

    val builder: StrictMode.VmPolicy.Builder = StrictMode.VmPolicy.Builder()
    StrictMode.setVmPolicy(builder.build())

    val textValue = if (title.isNotEmpty() && body.isNotEmpty())
        title + "\n\n" + body
    else if (title.isNotEmpty() && body.isEmpty())
        title
    else if (title.isEmpty() && body.isNotEmpty())
        body
    else
        ""

    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        type = "image/*"
        putExtra(Intent.EXTRA_TEXT, textValue)
        putExtra(Intent.EXTRA_TITLE, title)
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_STREAM, bmpUri)
    }

    val shareIntent = Intent.createChooser(sendIntent, "Share Image")
    startActivity(shareIntent)
}

fun Activity.disableTakeScreenShot() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE
    )
}

fun Activity.enableTakeScreenShot() {
    window.clearFlags(
        WindowManager.LayoutParams.FLAG_SECURE
    )
}