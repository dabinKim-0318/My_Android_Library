package com.example.kotlin_study.Android

import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("/orgs/{org}/repos")
    fun getRepoList(@Path("org") username: String):retrofit2.Call<GitRepositoryResponseData>

}


