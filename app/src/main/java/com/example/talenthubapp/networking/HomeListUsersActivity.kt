package com.example.talenthubapp.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talenthubapp.RecyclerviewOfNameAdapter
import com.example.talenthubapp.databinding.ActivityHomeListUsersBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeListUsersActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeListUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeListUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client =ApiConfig.getApiService()

        settingRVUsers(client)

    }

    private fun settingRVUsers(client: TalentHubGitHubUserApiService) {
        val rvAdapter = RecyclerviewOfNameAdapter()
        val getListUsersFromClient = client.getListUsers()

        binding.rvListUsers.layoutManager = LinearLayoutManager(this)
        binding.rvListUsers.adapter = rvAdapter

        showLoading(true)


        getListUsersFromClient.enqueue(object : Callback<List<UserGitHubModel>> {
            override fun onResponse(
                call: Call<List<UserGitHubModel>>,
                response: Response<List<UserGitHubModel>>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (!responseBody.isNullOrEmpty()) {
                        rvAdapter.addedListOfUsers(responseBody)
                    }
                } else {
                    Log.e("failedGetListUser", "onFailed: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<UserGitHubModel>>, t: Throwable) {
                showLoading(false)
                Log.e("failedGetListUser", "onFailed: ${t.message}")
            }

        })
    }


    private fun showLoading(isShow : Boolean) {
        if (isShow) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}