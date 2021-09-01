package com.example.kotlin_study.Android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_mylistener.*

class Mylistener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mylistener)

        //xml파일의 view를 Activity로 불러오기
        //1.java-변수에 담기(직접 찾아서 가져옴)
        //findViewById가 id가 hello인 문자열과 동일하면서, 속성이 textView
        //인 view를 찾아서 리턴
        val textView: TextView =findViewById(R.id.hello)

        //2.코틀린(xml을 import해서 가져옴)
        hello

    }
}