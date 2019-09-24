package com.example.jaytest

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button

class FloatingService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("FloatingService", "FloatingService.onStartCommand()");

        val layout = LayoutInflater.from(this).inflate(R.layout.activity_floating, null)
        layout.setOnTouchListener { v, event ->

            // HANDLE TOUCH EVENT HERE!

            Log.d("FloatingService", "v: $v, event: $event")
            false
        }

        val layoutParams = WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        )

        (getSystemService(Context.WINDOW_SERVICE) as WindowManager).addView(layout, layoutParams)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}