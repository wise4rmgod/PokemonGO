package com.dev.pokemongo.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.dev.pokemongo.MyApplication

object SharedPreferenceManager {

    private const val PREFS_FILE_KEY = "org.samaritan.test"

    /**
     * Enum representing your setting names or key for your setting.
     */
    enum class Key {
        PREFS_TOKEN, TUNNEL_KEY, SERVER_PHONE_NUM,
        APP_LANGUAGE, TUNNEL_ID, LAB_ID, DEVICE_ID,
        SERVER_URL
    }

    private val sharedPref: SharedPreferences =
        MyApplication.applicationContext()
            .getSharedPreferences(PREFS_FILE_KEY, Context.MODE_PRIVATE)

    fun getString(key: Key, defaultValue: String = ""): String {
        return sharedPref.getString(key.name, defaultValue) ?: ""
    }

    fun put(key: Key, value: String) {
        with(sharedPref.edit()) {
            putString(key.name, value)
            commit()
        }
    }

    fun clear() {
        sharedPref.edit().clear().apply()
    }
}