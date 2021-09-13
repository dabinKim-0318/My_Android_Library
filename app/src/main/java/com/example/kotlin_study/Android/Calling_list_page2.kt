package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_calling_list_page2.*

class Calling_list_page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_list_page2)

        val person=intent.getIntExtra("person", 0)
        bigStory.setText(person)

    }
}