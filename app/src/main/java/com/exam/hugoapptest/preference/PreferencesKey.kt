package com.exam.hugoapptest.preference

const val DEFAULT_FILE_PREFERENCES = "SETTINGS"

open class PreferencesKey(val preferenceGroupName: String, val key: String, val defaultValue: Any) {

    constructor(key: String, value: Any) : this(DEFAULT_FILE_PREFERENCES, key, value)

    init {
        ManagerPreferenceKey.addPreferenceKey(this)
    }

    override fun toString(): String {
        return key
    }
}