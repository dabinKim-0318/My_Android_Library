package com.example.kotlin_study.Server

//POST의 요청 바디가 되는 부분
data class RequestLoginData(
    val email: String,
    val password: String
)
