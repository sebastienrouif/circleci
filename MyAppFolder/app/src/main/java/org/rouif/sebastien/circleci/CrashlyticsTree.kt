package org.rouif.sebastien.circleci

import android.util.Log
import com.crashlytics.android.Crashlytics
import timber.log.Timber

class CrashlyticsTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        if (t == null) {
            Crashlytics.logException(Exception(message))
        } else {
            Crashlytics.logException(t)
        }
    }

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return priority == Log.ERROR
            || priority == Log.ASSERT
    }
}
