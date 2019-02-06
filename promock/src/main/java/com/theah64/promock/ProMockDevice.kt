package com.theah64.promock

data class ProMockDevice(
    val name: String,
    val uid: String
) {

    val keyValues: MutableList<ProMockKeyValue> = mutableListOf();

    /**
     * Adds key value to the list
     */
    fun addKeyValue(keyValue: ProMockKeyValue) {
        keyValues.add(keyValue)
    }


}