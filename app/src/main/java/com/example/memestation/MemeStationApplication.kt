package com.example.memestation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MemeStationApplication : Application(){

    @Override
    override fun onCreate() {
        super.onCreate()
    }

}