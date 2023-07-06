package com.example.talenthubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.talenthubapp.databinding.ActivitySecondMainBinding

class SecondMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRV()

        setGlide()

    }


    private fun setRV() {
        val listNames = listOf("Ikrima", "Abil", "Nanda", "Desni", "Naufal", "Adi", "Amanda", "Wulan")
        val rvOfNameAdapter = RecyclerviewOfNameAdapter()

        binding.rvListName.layoutManager = LinearLayoutManager(this)
        binding.rvListName.adapter = rvOfNameAdapter

        rvOfNameAdapter.addedListOfName(listNames)

    }

    private fun setGlide() {
        val url = "https://as2.ftcdn.net/v2/jpg/03/64/21/11/1000_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg"

        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_android_black_24dp)
            .into(binding.ivProfile)

    }

}