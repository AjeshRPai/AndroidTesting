package com.example.ajeshpai.androidtesting

import android.app.Application
import android.util.Log

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("onCreate","My application")
    }
}