package com.example.kotlin_study.Android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_study.R

class Fragment_three:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle", "F onCreateView")
        return inflater.inflate(R.layout.fragment_one, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}