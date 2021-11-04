package com.example.kotlin_study.Server

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityServerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

class ServerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            initNetwork()
        }

    }

//인터페이스
    interface SampleService {
        @Headers("Content-Type:application/json") //Header에서 정의되는 부분
        @POST(	"user/login") //HTTP메소드 + end point URL
        fun postLogin(
            @Body body:RequestLoginData  //POST는 응답바디가 있기때문에 @Body어노테이션을 통해 요청바디를 정의
        ):Call<Data> //요청바디로 부터 받아온 데이터인 응답바디를 callback 타입으로 정의
    }
//인터페이스 구현한 싱글톤
    object ServiceCreator {
        private val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

        private val retrofit: Retrofit = Retrofit.Builder() //레트로핏 빌더 생성(생성자 호출)
            .baseUrl(BASE_URL) //빌더 객체의 baseURL호출=서버의 메인 URL정달
            .addConverterFactory(GsonConverterFactory.create()) //gson컨버터 연동
            .build() //객체반환

        val sampleService: com.example.kotlin_study.Server.SampleService = retrofit.create(com.example.kotlin_study.Server.SampleService::class.java)  //SampleService 인터페이스를 구현한 구현체
    }

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPassword.text.toString()
        )

        val call: Call<Data> = ServiceCreator.sampleService.postLogin(requestLoginData)

        call.enqueue(object : Callback<Data> {
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ServerActivity,"성공",Toast.LENGTH_SHORT).show()
                    val data = response.body()?.email
                    Toast.makeText(this@ServerActivity, "${data}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ServerActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(this@ServerActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
