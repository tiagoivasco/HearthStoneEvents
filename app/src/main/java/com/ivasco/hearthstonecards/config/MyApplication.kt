package com.ivasco.hearthstonecards.config

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.ivasco.hearthstonecards.data.di.dataModule
import com.ivasco.hearthstonecards.ui.di.uiModule
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.security.ProviderInstaller
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        try {
            ProviderInstaller.installIfNeeded(this)
        } catch (e: GooglePlayServicesRepairableException) {
            GoogleApiAvailability.getInstance()
                .showErrorNotification(this, e.connectionStatusCode)
        } catch (e: Exception) {
            Log.e("MyApplication", e.message ?: e::class.java.simpleName)
        }
        startKoin {
            androidContext(this@MyApplication)
            modules(uiModule, dataModule)
        }
    }
}