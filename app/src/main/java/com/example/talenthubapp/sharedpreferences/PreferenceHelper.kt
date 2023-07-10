package com.example.talenthubapp.sharedpreferences

import android.content.Context
import com.example.talenthubapp.R

class PreferenceHelper(context : Context) {

    private val sharedPref = context.getSharedPreferences(context.getString(R.string.shared_preference_talenthub), Context.MODE_PRIVATE)
    private val editor = sharedPref.edit()

    fun putValueString(key : String, value : String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getValueString(key : String) : String? {
        return sharedPref.getString(key, "Data Kosong")
    }

    fun putValueInt(key : String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun getValueInt(key: String) : Int {
        return sharedPref.getInt(key, 0)
    }

    fun putValueBoolean(key : String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getValueBoolean(key: String) : Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun clearData() {
        editor.clear().apply()
    }


}