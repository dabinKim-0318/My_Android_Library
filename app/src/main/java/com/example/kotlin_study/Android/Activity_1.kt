package com.example.kotlin_study.Android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_1.*

class Activity_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)


        change_activity.setOnClickListener {
//            val intent2 = Intent(this@Activity_1, Activity_2::class.java)
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
//            startActivityForResult(intent2, 200)
            //request코드넣어야하는 이유는 Activity2에 보내지는 Intent들이 여러개이기때문에
            //return되는 Intent를 보낼때는 Intent를 식별할 수 있는 requestCode를 붙여서
            //Intent를 보내야 return되는 Activity2의 Intent를 확인할때 Activity1에서
            //보낸 Intent라는걸 확인할 수 있음

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number,", "" + resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}