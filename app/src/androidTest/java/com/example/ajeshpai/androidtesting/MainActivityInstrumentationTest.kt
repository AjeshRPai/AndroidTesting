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
    public val rule  = ActivityTestRule(MainActivity::class.java)


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
    }


    @Test
    fun login_valid(){
        Log.e("@Test","Performing login valid test")
        Espresso.onView(
                allOf(withHint("Username"),
                        withId(R.id.user_name)))
                .perform(ViewActions.typeText("Ajesh"))
                .check(matches(withText("Ajesh")))

        Espresso.onView(withId(R.id.password))
                .perform(ViewActions.typeText("password"))
                .check(matches(withText("password")))

        Espresso.onView(withId(R.id.login_button))
                .perform(ViewActions.click())
    }

    @Test
    fun login_Hint(){
        Log.e("@Test","Performing login hint test")
        Espresso.onView(allOf(
                            withId(R.id.login_result),
                            withText("LOGIN")))
                .check(matches(withText("LOGIN")))

    }

    @After
    fun after_test_method() {
        Log.e("@After", "Hi this is run after every test function")
    }

}