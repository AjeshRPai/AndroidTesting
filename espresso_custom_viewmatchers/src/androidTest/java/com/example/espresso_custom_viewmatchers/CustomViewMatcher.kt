package com.example.espresso_custom_viewmatchers

import android.support.design.widget.TextInputLayout
import android.view.View
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.runner.Description



fun hasTextInputLayoutError(error:String):Matcher<View>{
    return object:TypeSafeMatcher<View>(){
        override fun describeTo(description: org.hamcrest.Description?) {

        }

        override fun matchesSafely(item: View?): Boolean {
            item?.let {                        //if view is not null
                return if(it is TextInputLayout) //if view is textinput layout
                    it.error?.let {   //run if the hint is not false
                                return error.equals(it)
                            }?:kotlin.run {
                                return false
                            }
                else false
            }?:kotlin.run {
                return false
            }
        }
    }
}

fun hasTextInputLayoutHint(hint:String):Matcher<View>{
    return object:TypeSafeMatcher<View>(){
        override fun describeTo(description: org.hamcrest.Description?) {

        }

        override fun matchesSafely(item: View?): Boolean {
            item?.let {                        //if view is not null
                return if(it is TextInputLayout) //if view is textinput layout
                    it.hint?.let {   //run if the hint is not false
                        return hint.equals(it)
                    }?:kotlin.run {
                        return false
                    }
                else false
            }?:kotlin.run {
                return false
            }
        }
    }
}

fun Any?.ifNull(block: () -> Unit,null_block:()->Unit) {
    this?.let {
        block
    }?:kotlin.run {
        null_block
    }
}



