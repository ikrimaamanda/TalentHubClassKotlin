package com.example.talenthubapp.firebaserealtimedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talenthubapp.R
import com.example.talenthubapp.databinding.ActivityFirebaseRealtimeDbactivityBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseRealtimeDBActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirebaseRealtimeDbactivityBinding

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseRealtimeDbactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingFirebaseRealtimeDB()

        settingButton()

    }

    private fun settingFirebaseRealtimeDB() {
        database = FirebaseDatabase.getInstance().getReference("Users")
    }

    private fun settingButton() {
        binding.apply {
            btnSaveData.setOnClickListener {
                savedata()
            }
        }
    }


    private fun savedata() {
        binding.apply {
            val userName = etUserName.text.toString()
            val fullName = etFullName.text.toString()
            val email = etUserEmail.text.toString()

            val user = UserFirebaseRealtimeDBModel(userName, fullName, email)

            database.child(userName).setValue(user).addOnSuccessListener {
                etUserName.text.clear()
                etFullName.text.clear()
                etUserEmail.text.clear()

                Toast.makeText(this@FirebaseRealtimeDBActivity, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
            }
                .addOnCanceledListener {
                    Toast.makeText(this@FirebaseRealtimeDBActivity, "Batal disimpan!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this@FirebaseRealtimeDBActivity, "Data Gagal disimpan!", Toast.LENGTH_SHORT).show()
                }

        }
    }

}