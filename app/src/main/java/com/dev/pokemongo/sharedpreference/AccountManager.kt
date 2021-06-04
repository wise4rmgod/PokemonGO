package com.dev.pokemongo.sharedpreference

import android.util.Log


object AccountManager {
    private const val TOKEN_TYPE = "Bearer "


    fun getToken(): String {
        return SharedPreferenceManager.getString(SharedPreferenceManager.Key.PREFS_TOKEN)
    }

    fun setToken(value: String) {
        Log.d(AccountManager.javaClass.simpleName, "Token $value")

        if (value.isNotBlank())
            SharedPreferenceManager.put(SharedPreferenceManager.Key.PREFS_TOKEN, TOKEN_TYPE + value)
        else
            SharedPreferenceManager.put(SharedPreferenceManager.Key.PREFS_TOKEN, value)
    }

}