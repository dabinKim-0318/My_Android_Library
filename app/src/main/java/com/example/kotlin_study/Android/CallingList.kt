package com.example.kotlin_study.Android

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R

class PersonList(val name: String, val story: String) {
}

class CallingList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_list)

        val container = findViewById<LinearLayout>(R.id.container)
        val list = ArrayList<PersonList>()

        list.add(PersonList("김현희", "Hello"))
        list.add(PersonList("김수정", "심리학"))
        list.add(PersonList("김지태", "경영학"))
        list.add(PersonList("백점자", "경제학"))
        list.add(PersonList("추유림", "하츠"))
        list.add(PersonList("백송이", "해외"))
        list.add(PersonList("정세운", "내남편"))
        list.add(PersonList("조윤아", "비행기"))
        list.add(PersonList("도미영", "반도체"))

        val inflater = LayoutInflater.from(this@CallingList)

        for (i in 0 until list.size) {
            val itemView = inflater.inflate(R.layout.person_list, null, false)
            var name2 = itemView.findViewById<TextView>(R.id.name)
            var story2 = itemView.findViewById<TextView>(R.id.story)

            name2.setText(list.get(i).name)
            story2.setText(list.get(i).story)
            container.addView(itemView)
        }
    }
}