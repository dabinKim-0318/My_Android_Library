package com.example.kotlin_study.Android

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubServiceImplementation {

    //BASE_URL을 private const 변수로 저장해둠
    private const val BASE_URL = "https://api.github.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //GithubService는 Request메소드를 작성해둔 인터페이스 이름임
    val service = retrofit.create(GithubService::class.java)

}