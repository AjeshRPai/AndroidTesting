package com.example.espresso_intents

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class LaunchMainActivityTest {

    @Rule
    @JvmField
    val rule  = getRule()

    private fun getRule(): ActivityTestRule<MainActivity> {
        return ActivityTestRule(MainActivity::class.java,true,false)
    }

    @Test
     fun addModeTesting(){
        val intent=Intent(InstrumentationRegistry.getTargetContext(),MainActivity::class.java)
        intent.putExtra(MainActivity.ISINEDITMODEKEY,true)
        rule.launchActivity(intent)
        onView(withId(R.id.text_view)).check(matches(withText(R.string.editmode)))
    }

    @Test
     fun editModeTesting(){
        val intent=Intent(InstrumentationRegistry.getTargetContext(),MainActivity::class.java)
        intent.putExtra(MainActivity.ISINEDITMODEKEY,false)
        rule.launchActivity(intent)
        onView(withId(R.id.text_view)).check(matches(withText(R.string.addmode)))
    }


}