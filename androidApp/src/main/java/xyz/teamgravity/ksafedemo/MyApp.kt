package xyz.teamgravity.ksafedemo

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AppModule.init(this)
    }
}