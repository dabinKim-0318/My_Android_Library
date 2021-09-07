package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

    }

//    override fun onStart() {
//        super.onStart()
//        Log.d("lifecycle", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("lifecycle", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("lifecycle", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("lifecycle", "onStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("lifecycle", "onDestroy")
//    }
}
