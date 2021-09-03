package com.example.kotlin_study.Android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_2.*

class Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        result.setOnClickListener {
            val number1 = intent.getIntExtra("number1", 44)
            val number2 = intent.getIntExtra("number2", 0)
            Log.d("number", "" + number1)
            Log.d("number", "" + number2)

            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result",result)

            setResult(Activity.RESULT_OK,resultIntent)
            //Activity1에게 결과를 보내기 위해 보내줄 결과를 setResult메서드 인자로전달
            // 보내줄 결과값(data)이 없을떄(resultIntent)는 resultcode만 넣어주면 되는데
            // 이때 resultcode는 그냥 상수인데 가독성을 위해서 Activity.RESULT_OK같은
            //상수를 가져옴
            finish() //Activity2를 종료함 결과값을 보내주고 난 후 Activity를 스택에서 제거



            //Activity2 ->finish()로 종료
            //Activity1-Intent2
            //Activity1-Intent1
        }
    }
}