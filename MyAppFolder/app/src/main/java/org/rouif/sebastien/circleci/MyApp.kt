package org.rouif.sebastien.circleci

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupCrashlytics()
        setupTimber()
    }

    fun setupCrashlytics() {
        if (BuildConfig.IS_CI) {
            Fabric.with(this, Crashlytics())
        }
    }

    fun setupTimber() {
        if (BuildConfig.DEBUG && !BuildConfig.IS_CI) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }
}
