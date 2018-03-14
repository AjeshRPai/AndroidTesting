package com.example.espresso_intents

import android.app.Activity
import android.app.Instrumentation
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
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.Matchers.allOf
import org.junit.Before
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents
import junit.framework.TestCase.assertTrue
import org.junit.After


@RunWith(AndroidJUnit4::class)
class MainActivity_OnActivity_Result_Test {

    @Rule
    @JvmField
    val rule  = getRule()

    private fun getRule(): IntentsTestRule<MainActivity> {
        return IntentsTestRule(MainActivity::class.java)
    }


    @Test
     fun activityResult(){
        val testValue="MYTestValue"
        val result=getResult(testValue)
        intending(allOf(hasComponent(Main2Activity::class.java.name))).respondWith(result)

        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(withId(R.id.text_view)).check(matches(withText(testValue)))
    }


    @Test
    fun noActivityResult(){
        val testValue="MYTestValue"
        val result=getNoResult(testValue)
        intending(allOf(hasComponent(Main2Activity::class.java.getName()))).respondWith(result)

        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(withId(R.id.text_view)).check(matches(withText(R.string.sorry_no_result)))
    }

    @Test
    fun checkTheActivityHit(){
        onView(withId(R.id.button)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }

    private fun getResult(testValue:String): Instrumentation.ActivityResult {
        // Create the ActivityResult, with a null Intent since we do not want to return any data
        // back to the Activity.
        val resultData=Intent()
        resultData.putExtra(MainActivity.FIRST_DATA_KEY,testValue)
        return Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)
    }

    private fun getNoResult(testValue:String): Instrumentation.ActivityResult {
        // Create the ActivityResult, with a null Intent since we do not want to return any data
        // back to the Activity.
        val resultData=Intent()
        resultData.putExtra(MainActivity.FIRST_DATA_KEY,testValue)
        return Instrumentation.ActivityResult(Activity.RESULT_CANCELED, resultData)
    }







}