package com.example.coroutineexamapp

import android.app.Application
import com.example.coroutineexamapp.di.AppComponent
import com.example.coroutineexamapp.di.DaggerAppComponent

class App :Application(){

    companion object{
         lateinit var component : AppComponent
    }


    override fun onCreate() {
         component = DaggerAppComponent.builder().build()
         component.inject(this)
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}