package com.jairoqc.poketinder

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesRepository {
    companion object {
        private lateinit var sharedPreferences: SharedPreferences
        private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
        private const val USER_EMAIL_KEY = "USER_EMAIL_KEY"
        private const val USER_PASSWORD_KEY = "USER_PASSWORD_KEY"
        private const val DEFAULT_VALUE_FOR_EMPTY = ""
    }

    fun setSharedPreference(context: Context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
    }

    fun getUserEmail(): String {
        return sharedPreferences.getString(USER_EMAIL_KEY, DEFAULT_VALUE_FOR_EMPTY) ?: DEFAULT_VALUE_FOR_EMPTY
    }

    fun getUserPassword(): String {
        return sharedPreferences.getString(USER_PASSWORD_KEY, DEFAULT_VALUE_FOR_EMPTY) ?: DEFAULT_VALUE_FOR_EMPTY
    }

    fun saveUserEmail(email: String) {
        sharedPreferences
            .edit()
            .putString(USER_EMAIL_KEY, email)
            .apply()
    }

    fun saveUserPassword(password: String) {
        sharedPreferences
            .edit()
            .putString(USER_PASSWORD_KEY, password)
            .apply()
    }
}
