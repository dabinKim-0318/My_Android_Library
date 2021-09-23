package com.example.kotlin_study.Android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_calling_list2.*
import kotlinx.android.synthetic.main.person_list.view.*

//
//class callList(val name: String, val number: String) {
//
//}
//
//class CallingList2 : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_calling_list2)
//
//        //데이터 리스트 만들기
//        val phonelist = ArrayList<callList>()
//        for (item in 0..20) {
//            phonelist.add(callList(" $item ", "010- $item -8437"))
//
//        }
//
//        val adapter = RecyclerViewAdapter2(phonelist, LayoutInflater.from(this@CallingList2))
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this@CallingList2)
//        //recyclerView.layoutManager = GridLayoutManager(this@RecycleViewActivity,2)
//
//
//    }
//}
//
//class RecyclerViewAdapter2(
//    val phonelist: ArrayList<callList>,
//    val inflater: LayoutInflater
//) : RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder2>() {
//
//    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var name: TextView
//        var story: TextView
//
//        init {
//            name = itemView.findViewById(R.id.name)
//            story = itemView.findViewById(R.id.story)
//            itemView.setOnClickListener {
//                val positoon:Int=adapterPosition
//                val number=phonelist.get(positoon).number
//                Log.d("number",number)
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder2 {
//        val view = inflater.inflate(R.layout.person_list, parent, false)
//        return ViewHolder2(view)
//    }
//
//    override fun getItemCount(): Int {
//        return phonelist.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
//        holder.name.setText(phonelist.get(position).name)
//        holder.story.setText(phonelist.get(position).number)
//    }
//
//}

class callist(val name: String, val number: String) {}

class CallingList2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_list2)

        val phonelist = ArrayList<callist>()
        for (item in 0..20) {
            phonelist.add(callist(" $item ", "010- $item "))
        }

       val adapter= RecyclerViewAdapter2(phonelist, LayoutInflater.from(this@CallingList2))
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}

class RecyclerViewAdapter2(
    val phonelist: ArrayList<callist>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder2>() {

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var story: TextView

        init {
            name = itemView.name
            story = itemView.story
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val view = inflater.inflate(R.layout.person_list, parent, false)
        return ViewHolder2(view)
    }

    override fun getItemCount(): Int {
        return phonelist.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
       holder.name.setText(phonelist.get(position).name)
       holder.story.setText(phonelist.get(position).number)

    }


}



