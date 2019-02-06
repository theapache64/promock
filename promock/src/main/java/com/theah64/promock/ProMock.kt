package com.theah64.promock

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

object ProMock {

    // device list
    private var keyValues: MutableList<ProMockKeyValue>? = null

    @SuppressLint("HardwareIds")
    fun init(context: Context, vararg devices: ProMockDevice) {

        // Getting current device id
        val currentId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

        // looping through each device to get values corresponding to current device
        for (device in devices) {
            if (currentId == device.uid) {
                // device found, adding values
                keyValues = device.keyValues
                break
            }
        }

    }

    /**
     * Gets value corresponding to passed key
     */
    fun get(key: Any, defaultValue: Any? = null): Any? {

        keyValues?.let {
            for (keyValue in it) {
                if (keyValue.key == key) {
                    return keyValue.value
                }
            }
        }

        return defaultValue
    }

    fun getString(key: Any): String {
        return ProMock.get(key, "").toString()
    }


}