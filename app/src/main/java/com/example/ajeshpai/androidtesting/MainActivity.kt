package com.example.ajeshpai.androidtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val login_button by lazy{
        findViewById<Button>(R.id.login_button)
    }

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
