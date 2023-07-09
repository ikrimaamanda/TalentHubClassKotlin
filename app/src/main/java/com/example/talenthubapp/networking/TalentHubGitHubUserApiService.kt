package com.example.talenthubapp.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TalentHubGitHubUserApiService {

    @GET("users")
    fun getListUsers() : Call<List<UserGitHubModel>>

    @GET("users/{username}")
    fun getDetailUser(@Path("username") username : String) : Call<UserGitHubModel>
}