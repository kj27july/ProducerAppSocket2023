package com.socket.producer

import android.app.Application
import com.socket.producer.controllers.XtsBuilder

class SocketApp : Application(){
    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        XtsBuilder.build(this)
    }
}
