package com.example.kotlin_study.Server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    private val retrofit: Retrofit = Retrofit.Builder() //레트로핏 빌더 생성(생성자 호출)
        .baseUrl(BASE_URL) //빌더 객체의 baseURL호출=서버의 메인 URL정달
        .addConverterFactory(GsonConverterFactory.create()) //gson컨버터 연동
        .build() //객체반환

    val sampleService: SampleService = retrofit.create(SampleService::class.java)  //SampleService 인터페이스를 구현한 구현체
}