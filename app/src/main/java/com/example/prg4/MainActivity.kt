package com.example.prg4

import androidx.appcompat.app.AppCompatActivity
import com.example.prg4.R
import android.os.Bundle
import com.example.prg4.MainActivity.MyTimer
import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.view.View
import android.widget.Button
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var btn: Button? = null
    var running = false
    var ia = intArrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById<View>(R.id.btn_wall) as Button
        btn!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (!running) {
            Timer().schedule(MyTimer(), 0, 3000)
            running = true
        }
    }

    private inner class MyTimer : TimerTask() {
        override fun run() {
            try {
                val wallpaperManager = WallpaperManager.getInstance(baseContext)
                val random = Random()
                wallpaperManager.setBitmap(
                    BitmapFactory.decodeResource(
                        resources,
                        ia[random.nextInt(5)]
                    )
                )
            } catch (e: IOException) {
            }
        }
    }
}