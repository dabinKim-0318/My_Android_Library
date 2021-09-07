package com.example.kotlin_study.Android

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_add.*

class CarForList(val name: String,val engine: String) {}

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view2)

        //아이템 리스트 준비
        val carList = mutableListOf<CarForList>()
        for (i in 0 until 10){
            carList.add(CarForList(" $i 번째 자동차","$i 번째 순위"))
        }

        val container=findViewById<LinearLayout>(R.id.addview_container)  //이 container역할을 하는 LinearLayout에 리스트를 주루룩 넣어서 스크롤뷰로 감쌀거야
        val inflater=this@AddViewActivity.layoutInflater




    }
}