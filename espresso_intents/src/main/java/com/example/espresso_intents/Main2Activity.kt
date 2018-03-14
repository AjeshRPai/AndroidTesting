package com.example.espresso_intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val intent= Intent()
            intent.putExtra(MainActivity.FIRST_DATA_KEY,"Second Activity")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

}
