package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//임포트는 내가 해당 파일에서 가져다 쓸 것 정리하는거고
//이 메인액티비티는 기본으로 상단 2개의 임포트가 디폴트임
//MainActivity는 AppCompatActivity라는 클래스를 상속받았음
//MainActivity에서는 디폴트로 onCreate매서드가 선언되어있음

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_test_answer)
    }
}