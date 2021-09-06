package com.example.kotlin_study.Android

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_res.*

class res : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        val context: Context =this
        val applicationContext:Context=getApplicationContext()

        //res의 string값 불러오기 1
        val ment = resources.getString(R.string.restest)

        //res의 string값 불러오기2
        val ment2 = getString(R.string.restest)

        //Activity에서 string값 변경하기
        text.setText(getString(R.string.restest))
        text.setText("직접 변경도 가능")

        //SDK버전에 따른 분기처리
        //Activity에서 color값 변경하기: public static final int M = 23;
        val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            button.setBackgroundColor(getColor(R.color.restest))
        } else {
            button.setBackgroundColor(resources.getColor(R.color.restest))
        }



    }
}
