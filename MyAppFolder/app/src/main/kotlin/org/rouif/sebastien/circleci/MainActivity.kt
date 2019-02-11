package org.rouif.sebastien.circleci

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtons()
    }

    fun setupButtons() {
        force_crash.setOnClickListener {
            throw RuntimeException("This is a crash")
        }
        button_verbose.setOnClickListener {
            Timber.v(Exception("button_verbose"))
        }
        button_debug.setOnClickListener {
            Timber.d(Exception("button_debug"))
        }
        button_info.setOnClickListener {
            Timber.i(Exception("button_info"))
        }
        button_warn.setOnClickListener {
            Timber.w(Exception("button_warn"))
        }
        button_error.setOnClickListener {
            Timber.e(Exception("button_error"))
        }
        button_assert.setOnClickListener {
            Timber.wtf(Exception("button_assert"))
        }

        button_error.setOnLongClickListener {
            Timber.e("button_error")
            true
        }
    }
}
