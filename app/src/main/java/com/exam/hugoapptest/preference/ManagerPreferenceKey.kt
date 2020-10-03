package com.exam.hugoapptest.preference

object ManagerPreferenceKey {

    @JvmField
    val values: ArrayList<PreferencesKey> = ArrayList()

    fun addPreferenceKey(key: PreferencesKey) {
        values.add(key)
    }
}