package com.example.kotlin_study.Server

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService {
    @Headers("Content-Type:application/json") //Header에서 정의되는 부분
    @POST(	"user/login") //HTTP메소드 + end point URL
    fun postLogin(
        @Body body:RequestLoginData  //POST는 응답바디가 있기때문에 @Body어노테이션을 통해 요청바디를 정의
    ):Call<Data> //요청바디로 부터 받아온 데이터인 응답바디를 callback 타입으로 정의
}
