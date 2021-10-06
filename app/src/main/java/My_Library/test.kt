package My_Library

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlin_study.R.layout.activity_test)

        var et_input: EditText? = null
        var tv_input_length: TextView? = null
        et_input = findViewById(com.example.kotlin_study.R.id.et_input)
        tv_input_length = findViewById(com.example.kotlin_study.R.id.tv_input_length)

        //EditText 리스너 (입력시 반응)
        et_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                tv_input_length.setText(s.length.toString() + "글자") //글자수 TextView에 보여주기.
            }
        })


    }
}


