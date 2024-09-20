package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences

object ShareUtil {
    private var sps: SharedPreferences? = null
    private fun getSps(context: Context): SharedPreferences {
        if (sps == null) {
            sps = context.getSharedPreferences("default_sp", Context.MODE_PRIVATE)
        }
        return sps!!
    }

    fun putString(key: String, value: String?, context: Context) {
        if (!value.isNullOrBlank()) {
            var editor: SharedPreferences.Editor = getSps(context).edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getString(key: String, context: Context): String? {
        if (key.isNotBlank()) {
            val sps: SharedPreferences = getSps(context)
            return sps.getString(key, "")
        }
        return null
    }

    fun putBoolean(key: String, value: Boolean, context: Context) {
        val editor: SharedPreferences.Editor = getSps(context).edit()
        editor.putBoolean(key, value)
        editor.apply()

    }

    fun getBoolean(key: String, context: Context): Boolean {
        if (key.isNotBlank()) {
            val sps: SharedPreferences = getSps(context)
            return sps.getBoolean(key, false)
        }
        return false
    }
}