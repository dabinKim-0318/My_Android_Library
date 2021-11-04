package com.example.kotlin_study.Server

//POST의 응답 바디가 되는 부분
data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String
)

data class Data(
    val id: Int,
    val name: String,
    val email: String
)
