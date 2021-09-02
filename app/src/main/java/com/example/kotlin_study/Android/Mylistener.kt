package com.example.kotlin_study.Android

import android.os.Bundle
import android.util.Log
import android.view.View
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
        val textView: TextView = findViewById(R.id.hello)

        //2.코틀린(xml을 import해서 가져옴)
        hello.setOnClickListener {
            Log.d("click", "Click")
        }

        hello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click")
            }
        }
        )
//가장 마지막 코드가 실행됨
        val click = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d("click", "Click")
                hello.setText("안녕하세요")  //onClick가 실행되면 setText가 실행됨=hello->안녕하세요
            }
        }

        //View를 조작하는 방법
        //1. textView의 text속성을 직접 조작할 수 있음
        // hello.setText("안녕하세요")  //hello가 안녕하세요로 바뀜
        //2. ImageView의 속성을 직접 조작할 수 있음
        //image.setImageResource(R.drawable.mylove)
        hello.setOnClickListener(click)
        image.setImageResource(R.drawable.mylove)
    }

}