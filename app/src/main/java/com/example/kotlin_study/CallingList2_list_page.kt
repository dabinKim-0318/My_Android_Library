package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calling_list2_list_page.*

class CallingList2_list_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_list2_list_page)

        getInfo()

    }

    fun getInfo() {
        val number = intent.getIntExtra("number", 0)
        val name = intent.getIntExtra("name", 0)
        bigStory.setText(name)
        number2.setText(number)
    }
}