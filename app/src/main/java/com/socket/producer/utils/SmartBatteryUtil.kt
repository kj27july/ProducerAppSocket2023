package com.socket.producer.utils

import android.annotation.SuppressLint
import android.content.Context
import com.socket.producer.SocketApp

object SmartBatteryUtil {
    private const val POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile"
    private const val BATTERY_CAPACITY_METHOD = "getBatteryCapacity"

    @SuppressLint("PrivateApi")
    fun getBatteryCapacity(): Int {
        var batteryCapacity = 0.0
        try {
            val powerProfile = Class.forName(POWER_PROFILE_CLASS)
                .getConstructor(Context::class.java)
                .newInstance(SocketApp.instance)
            batteryCapacity = Class.forName(POWER_PROFILE_CLASS)
                .getMethod(BATTERY_CAPACITY_METHOD)
                .invoke(powerProfile) as Double
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return batteryCapacity.toInt()
    }
}