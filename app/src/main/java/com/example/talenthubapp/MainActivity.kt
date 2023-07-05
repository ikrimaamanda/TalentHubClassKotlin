    package com.example.talenthubapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.talenthubapp.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {

        private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMoveToOtherActivity()

//        val textView = findViewById<TextView>(R.id.tv_text)

        binding.tvText.text = String.format("Hello TalentHub Class!")

//        textView.text = String.format("Hello TalentHub Class!")

//        setUI()

    }

        private fun setMoveToOtherActivity() {
            binding.btnMainActivity.setOnClickListener {
                val i = Intent(this, SecondMainActivity::class.java)
                startActivity(i)
            }
        }


//        private fun setUI() {
//            binding.apply {
//                tvText
//            }
//        }

}