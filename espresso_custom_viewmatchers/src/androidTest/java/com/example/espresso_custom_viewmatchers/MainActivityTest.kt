package com.example.espresso_custom_viewmatchers

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
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId



@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val rule  = getRule()

    private fun getRule(): ActivityTestRule<MainActivity> {
        return ActivityTestRule(MainActivity::class.java)
    }

    @Test
    fun normalEditText(){
        onView(withId(R.id.editText)).perform(ViewActions.typeText("ajesh@co.in"))
        onView(withId(R.id.button2)).perform(ViewActions.click())
        onView(withId(R.id.editText)).check(ViewAssertions.matches(ViewMatchers.hasErrorText("Invalid email")))
    }

    @Test
    fun appCompatEditText(){
        onView(withId(R.id.appCompatEditText)).perform(ViewActions.typeText("ajesh@co.in"))
        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(withId(R.id.inputlayout))
                .check(ViewAssertions.matches(hasTextInputLayoutError("Invalid email")))
    }
}