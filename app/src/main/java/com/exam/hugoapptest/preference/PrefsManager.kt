package com.exam.hugoapptest.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PrefsManager private constructor(private val context: Context) {

    private fun getPreferencesFile(groupPreferenceName: String): SharedPreferences {
        return if (groupPreferenceName.isEmpty()) {
            PreferenceManager.getDefaultSharedPreferences(context)
        } else context.getSharedPreferences(groupPreferenceName, Context.MODE_PRIVATE)
    }

    private fun getEditor(groupPreferenceName: String): SharedPreferences.Editor {
        val customize_pref = getPreferencesFile(groupPreferenceName)
        return customize_pref.edit()
    }

    operator fun set(preKey: PreferencesKey, value: String) {
        val editor = getEditor(preKey.preferenceGroupName)
        editor.putString(preKey.key, value)
        editor.commit()
    }

    fun getString(preferenceKey: PreferencesKey, defaultValue: String): String? {
        val sharedFile = getPreferencesFile(preferenceKey.preferenceGroupName)
        return sharedFile.getString(preferenceKey.key, defaultValue)
    }

    private fun resetUserPreference(preference: PreferencesKey) {
        val defaultValue = preference.defaultValue
        when (defaultValue) {
            is String -> set(preference, defaultValue)
        }
    }

    fun resetPreferences() {
        for (preferencesKey in ManagerPreferenceKey.values)
            resetUserPreference(preferencesKey)
    }

    companion object {

        private var sInstance: PrefsManager? = null

        val instance: PrefsManager
            get() {
                if (sInstance == null)
                    throw UnsupportedOperationException("Before call this method you have to init it ")
                return sInstance as PrefsManager
            }

        fun init(context: Context) {
            if (sInstance == null)
                sInstance =
                    PrefsManager(context)
        }

        var LIST_CAR_REGISTERED = PreferencesKey("registered_car_list", "")
        var LIST_CAR_ACCESS = PreferencesKey("registered_car_access", "")
    }

}