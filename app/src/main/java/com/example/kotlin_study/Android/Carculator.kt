package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_carculator.*

class Carculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carculator)


        var result = 0  //11
        var string = ""

        button_1.setOnClickListener {
            var one: String = "1"
            string += one  //11
            button_result.setText(string)
            //강사는 string=string+"1" 이렇게함
        }
        button_2.setOnClickListener {
            var two: String = "2"
            string = string + two  //11
            button_result.setText(string)
        }
        button_3.setOnClickListener {
            var two: String = "3"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_4.setOnClickListener {
            var two: String = "4"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_5.setOnClickListener {
            var two: String = "5"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_6.setOnClickListener {
            var two: String = "6"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_7.setOnClickListener {
            var two: String = "7"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_8.setOnClickListener {
            var two: String = "8"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_9.setOnClickListener {
            var two: String = "9"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_zero.setOnClickListener {
            var two: String = "0"
            var value: String = ""
            string = string + two  //11
            button_result.setText(string)
        }
        button_CA.setOnClickListener {
            result = 0
            button_result.setText("0")
            string = ""
        }

        button_result.setOnClickListener {

        }

        button_plus.setOnClickListener {
            button_result.setText("+")  //+
            //plus버튼을 클릭하면 true가 되어 덧셈실행
            result = result + string.toInt()
            string = ""
            button_result.setText("" + result)

            //old=(old.toInt()+new.toInt()).toString() --->강제 형변환 이렇게도 가능능


        }

    }
}