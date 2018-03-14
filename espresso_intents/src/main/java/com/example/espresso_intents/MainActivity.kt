package com.example.espresso_intents

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val ISINEDITMODEKEY="com.edit.mode"
        val FIRSTREQUESTCODE=123
        val SECONDREQUESTCODE=234
        val FIRST_DATA_KEY="com.my.data.123"
        val SECOND_DATA_KEY="com.my.data.234"
    }


    val ISINEDITMODE by lazy {
        intent.getBooleanExtra(ISINEDITMODEKEY,false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ISINEDITMODE)text_view.setText(getString(R.string.editmode))
        else text_view.setText(getString(R.string.addmode))

        button.setOnClickListener {
            startActivityForResult(Intent(this@MainActivity,Main2Activity::class.java),FIRSTREQUESTCODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode==Activity.RESULT_OK){
/*
            if(requestCode== FIRSTREQUESTCODE){
*/             if(data!=null) {
                text_view.setText(data.getStringExtra(FIRST_DATA_KEY))
                button.visibility = View.VISIBLE
            }
            /*}else if (requestCode== SECONDREQUESTCODE){
                text_view.setText(data.getStringExtra(SECOND_DATA_KEY))
                button.visibility= View.GONE
            }*/
        }else{
            text_view.setText(getString(R.string.sorry_no_result))
        }
    }
}
