package com.example.kotlin_study.Android

import com.google.gson.annotations.SerializedName

data class GitRepositoryResponseData (
    @SerializedName("name")
    val repoName : String,
    @SerializedName("id")
    val id: Int
)
