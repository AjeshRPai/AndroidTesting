package com.example.espresso_custom_viewmatchers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     val layout:TextInputLayout by lazy {
         findViewById<TextInputLayout>(R.id.inputlayout)
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            layout.error="Invalid email"
        }

        button2.setOnClickListener{
                editText.error="Invalid email"
        }
    }
}
