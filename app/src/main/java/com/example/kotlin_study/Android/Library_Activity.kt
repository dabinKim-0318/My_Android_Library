package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_library.*

class Library_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val url = "https://i.esdrop.com/d/i604ibqnl50b/OZ1dWvxKwh.jpg"



        Glide.with(this@Library_Activity)
            .load(url)
            .into(glide)


    }
}