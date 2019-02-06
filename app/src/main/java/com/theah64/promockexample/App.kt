package com.theah64.promockexample

import android.app.Application
import android.util.Log
import com.theah64.promock.ProMock
import com.theah64.promock.ProMockDevice
import com.theah64.promock.ProMockKeyValue

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.d("X", "Current device ID is " + ProMock.getDeviceId(this))

        // Creating devices
        val device1 = ProMockDevice("OnePlus6", "8ab6d7ccc06a1703")
        val device2 = ProMockDevice("MotoXStyle", "3f6af0e1ef0d3722")

        // Creating values for device 2
        val usernameDev1 = ProMockKeyValue(R.id.username, "theapache64")
        val passwordDev1 = ProMockKeyValue(R.id.password, "pass1234")

        // Creating values for device 1
        val usernameDev2 = ProMockKeyValue(R.id.username, "axefox6")
        val passwordDev2 = ProMockKeyValue(R.id.password, "admin1234")


        // Attaching key value to device 1
        device1.addKeyValue(usernameDev1)
        device1.addKeyValue(passwordDev1)

        // Attaching key value to device 2
        device2.addKeyValue(usernameDev2)
        device2.addKeyValue(passwordDev2)


        // Finally initializing
        ProMock.init(this, device1, device2)
    }
}