package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_phone_book_detail.*

class PhoneBook_detail_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)
        getPeronInfo()

        back.setOnClickListener {
            onBackPressed()
        }

    }

    fun getPeronInfo() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}