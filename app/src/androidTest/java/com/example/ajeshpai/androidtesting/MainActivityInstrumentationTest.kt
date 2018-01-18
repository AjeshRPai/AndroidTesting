package com.example.ajeshpai.androidtesting

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.ActivityInstrumentationTestCase2
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Matcher
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.hamcrest.Matchers.allOf


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest {

    @Rule
    @JvmField
    public val rule  = ActivityTestRule(MainActivity::class.java)

    @Test
    fun login_Hint(){

        Espresso.onView(
                    allOf(withHint("Username"),
                            withId(R.id.user_name)))
                .perform(ViewActions.typeText("Ajesh"))
                .check(matches(withText("Ajesh")))

        Espresso.onView(allOf(
                            withId(R.id.login_result),
                            withText("LOGIN")))
                .check(matches(withText("LOGIN")))

    }




}