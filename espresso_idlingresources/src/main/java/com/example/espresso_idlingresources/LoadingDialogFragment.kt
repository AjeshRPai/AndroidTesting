package com.example.espresso_idlingresources

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.text.format.DateUtils

import java.lang.ref.WeakReference

class LoadingDialogFragment : DialogFragment() {

    private val handler: LoadingHandler

    init {
        this.handler = LoadingHandler(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        handler.sendEmptyMessageDelayed(LoadingHandler.MSG_DISMISS, DELAY)

        return AlertDialog.Builder(this.context!!)
                .setTitle(R.string.loading)
                .setMessage(R.string.please_wait)
                .create()
    }

    override fun onDestroyView() {
        handler.removeMessages(LoadingHandler.MSG_DISMISS)
        super.onDestroyView()
    }

    private class LoadingHandler(fragment: DialogFragment) : Handler() {
        private val ref: WeakReference<DialogFragment>

        init {
            ref = WeakReference(fragment)
        }

        override fun handleMessage(msg: Message) {
            val fragment = ref.get()
            if (fragment != null) {
                fragment.dismiss()
                val activity = fragment.activity
                (activity as? MainActivity)?.onLoadingFinished()
            }
        }

        companion object {
            @JvmStatic
            val MSG_DISMISS = 0
        }
    }

    companion object {
        val TAG = "Loading"

        private val DELAY = DateUtils.SECOND_IN_MILLIS * 3
    }
}