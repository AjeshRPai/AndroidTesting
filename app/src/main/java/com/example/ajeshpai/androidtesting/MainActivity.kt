package com.example.ajeshpai.androidtesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val button_login by lazy{
        findViewById<Button>(R.id.login_button)
    }

    private val editText_username by lazy {
        findViewById<EditText>(R.id.user_name)
    }

    private val editText_password by lazy {
        findViewById<EditText>(R.id.password)
    }

    private val textView_result by lazy {
        findViewById<TextView>(R.id.login_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("Activity","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_login.setOnClickListener{
            if(editText_username.text.toString().equals("Ajesh") &&
                    editText_password.text.toString().equals("password"))
                textView_result.text=getString(R.string.login_success)
            else
                textView_result.text=getString(R.string.login_failed)
        }

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
