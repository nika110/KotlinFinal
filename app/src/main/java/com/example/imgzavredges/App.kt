package com.example.imgzavredges

import android.app.Application

class App: Application() {
    companion object{
        @JvmStatic lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}