package com.example.talenthubapp.sharedpreferences

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.talenthubapp.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySharedPreferencesBinding

    private lateinit var sharedPref : PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingSharedPref()

        settingButton()
    }

    private fun settingSharedPref() {
        sharedPref = PreferenceHelper(this)
    }

    private fun settingButton() {
        binding.apply {
            val name = sharedPref.getValueString(Constant.PREF_NAME)
            val semester = sharedPref.getValueInt(Constant.PREF_SEMESTER)
            val isLogin = sharedPref.getValueBoolean(Constant.PREF_LOGIN)

            tvShowData.text = String.format("Name => $name, \nSemester => $semester, \nStatus Login => $isLogin")

            btnTestString.setOnClickListener {
                sharedPref.putValueString(Constant.PREF_NAME, "TalentHub Class")

                Toast.makeText(this@SharedPreferencesActivity, name, Toast.LENGTH_SHORT).show()
            }

            btnTestInteger.setOnClickListener {
                sharedPref.putValueInt(Constant.PREF_SEMESTER, 7)

                Toast.makeText(this@SharedPreferencesActivity, semester.toString(), Toast.LENGTH_SHORT).show()
            }

            btnTestBoolean.setOnClickListener {
                sharedPref.putValueBoolean(Constant.PREF_LOGIN, true)

                Toast.makeText(this@SharedPreferencesActivity, isLogin.toString(), Toast.LENGTH_SHORT).show()
            }

            btnTestClearData.setOnClickListener {
                sharedPref.clearData()

                Toast.makeText(this@SharedPreferencesActivity, "Data dihapus", Toast.LENGTH_SHORT).show()
            }


        }
    }

}