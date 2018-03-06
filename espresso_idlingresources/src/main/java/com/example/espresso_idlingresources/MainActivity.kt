package com.example.espresso_idlingresources

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
import android.widget.TextView
import java.util.concurrent.atomic.AtomicInteger


class MainActivity : AppCompatActivity(), IdlingResource {
    private var textView: TextView? = null

    private val counter = AtomicInteger(0)

    @Volatile
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    val countingIdlingResource: IdlingResource
        @VisibleForTesting
        get() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)

        counter.incrementAndGet()

        val fragment = LoadingDialogFragment()
        fragment.setCancelable(false)
        fragment.show(supportFragmentManager, LoadingDialogFragment.TAG)
    }

    fun onLoadingFinished() {
        counter.decrementAndGet()
        resourceCallback!!.onTransitionToIdle()
        textView!!.setText(R.string.done)
    }

    override fun getName(): String {
        return "Main Fragment"
    }

    override fun isIdleNow(): Boolean {
        return counter.get() == 0
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback) {
        this.resourceCallback = callback
    }
}
