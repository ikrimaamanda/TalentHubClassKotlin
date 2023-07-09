package com.example.talenthubapp.networking

import com.google.gson.annotations.SerializedName

data class UserGitHubModel(
    @SerializedName("login") val userName : String? = "",
    @SerializedName("avatar_url") val avatarURL : String? = "",
    val name : String? = ""
)
