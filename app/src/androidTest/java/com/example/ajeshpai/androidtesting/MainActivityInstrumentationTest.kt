package com.example.ajeshpai.androidtesting

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.runner.RunWith
import java.util.regex.Matcher
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.hamcrest.Matchers.allOf
import org.junit.*


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest {

    //rule is initialized
    @Rule
    @JvmField
    public val rule  = ActivityTestRule(MainActivity::class.java,false,false)

    private val resources by lazy {
        rule.activity.resources
    }


    private val username_tobe_typed="Ajesh"
    private val password_tobe_typed="password"



    private fun getRule(): ActivityTestRule<MainActivity> {
        Log.e("Initalising rule","getting Mainactivity")
        return ActivityTestRule(MainActivity::class.java,false,false)
    }


    companion object {

        @BeforeClass
        @JvmStatic
        fun before_class_method(){
            Log.e("@Before Class","Hi this is run before anything")
        }

        @AfterClass
        @JvmStatic
        fun after_class_method(){
            Log.e("@After Class","Hi this is run after everything")
        }

    }

    @Before
    fun before_test_method(){
        Log.e("@Before","Hi this is run before every test function")
        //Lets check if the hints are correct on edit texts
    }


    @Test
    fun login_valid(){
        Log.e("@Test","Performing login valid test")
        Espresso.onView((withId(R.id.user_name)))
                .perform(ViewActions.typeText(username_tobe_typed))
                .check(matches(withText("Ajesh")))

        Espresso.onView(withId(R.id.password))
                .perform(ViewActions.typeText(password_tobe_typed))
                .check(matches(withText("password")))

        Espresso.onView(withId(R.id.login_button))
                .perform(ViewActions.click())
    }

    @Test
    fun login_Hint(){
        Log.e("@Test","Performing login hint test")
        Espresso.onView(withId(R.id.user_name))
                .check(matches(withHint(resources.getString(R.string.username_hint))))
        Espresso.onView(withId(R.id.password))
                .check(matches(withHint(resources.getString(R.string.password_hint))))
        Espresso.onView(withId(R.id.login_button))
                .check(matches(withText(resources.getString(R.string.login_button))))

    }

    @After
    fun after_test_method() {
        Log.e("@After", "Hi this is run after every test function")
    }

}