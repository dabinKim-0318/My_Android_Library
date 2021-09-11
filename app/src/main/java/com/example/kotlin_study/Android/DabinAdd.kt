package com.example.kotlin_study.Android

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R

class CarForList2(val name: String, val engine: String) {}
class DabinAdd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dabin_add)

        //아이템 리스트 준비
        val carList = mutableListOf<CarForList2>()
        for (i in 0 until 10) {
            carList.add(CarForList2(" $i 번째 자동차", "$i 번째 순위"))
        }


        //container 불러오기
        val container: LinearLayout = findViewById(R.id.addview_container2)

        //inflater만들기
        val inflater = LayoutInflater.from(this@DabinAdd)

        //반복문 돌면서 객체 10개 생성해서 담음
        for (i in 0 until carList.size) {
            //inflater.inflate()로 객체 만들어서
            val itemView = inflater.inflate(R.layout.item_view, null, false)

            //itemview의 text속성들을 변수에 담아서
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)

            //변수에 담은 text속성들을 setText로 조작 후
            carNameView.setText(carList.get(i).name)
            carEngineView.setText(carList.get(i).engine)

            //container에 addView로 객체를 담음
            container.addView(itemView)
        }
    }
}