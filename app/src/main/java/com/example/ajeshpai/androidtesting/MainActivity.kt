package com.example.ajeshpai.androidtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("Activity","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.e("Activity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("Activity","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("Activity","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("Activity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("Activity","onDestroy")
        super.onDestroy()
    }


}
