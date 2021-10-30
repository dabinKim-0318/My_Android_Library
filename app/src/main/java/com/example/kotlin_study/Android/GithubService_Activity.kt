package com.example.kotlin_study.Android

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GithubService_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_service)

        val call: Call<GitRepositoryResponseData> = GithubServiceImplementation.service.getRepoList("choheeis")

        call.enqueue(
            object : Callback<GitRepositoryResponseData> {
                // 서버 통신에 실패했을 때 처리할 작업을 작성한다.
                override fun onFailure(call: Call<GitRepositoryResponseData>, t: Throwable) {
                    Log.e("server_test", "fail")
                }

                // 서버 통신에 성공했을 때 처리할 작업을 작성한다.
                // 이 메소드의 매개변수에 있는 Response에 서버에서 응답 받아온 데이터가 들어있다.
                // Response에 대해서 -> https://square.github.io/retrofit/2.x/retrofit/retrofit2/Response.html
                override fun onResponse(
                    call: Call<GitRepositoryResponseData>,
                    response: Response<GitRepositoryResponseData>
                ) {
                    if (response.isSuccessful) {
                        val result: GitRepositoryResponseData =response.body()!!
                        val name = findViewById<TextView>(R.id.tv_github)
                        name.setText(result.repoName)
                        // 여기에 응답 받아온 데이터를 가지고 처리할 코드를 작성!
                        // 받아온 데이터를 textView에 set 한다던지!
                    }
                }
            }
        )
    }
}