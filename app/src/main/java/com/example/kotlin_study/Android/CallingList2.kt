package com.example.kotlin_study.Android

import android.app.Activity
import android.content.Intent
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


class callList(val name: String, val number: String) {}

class CallingList2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_list2)

        //데이터 리스트 만들기
        val phonelist = ArrayList<callList>()
        for (item in 0..20) {
            phonelist.add(callList(" $item ", "010- $item -8437"))
        }

        //recyclerView->xml에 만들어둔 recuclearView에 adapter연결하기
        recyclerView.adapter = RecyclerViewAdapter2(
            phonelist = phonelist,
            inflater = LayoutInflater.from(this@CallingList2),
            activity = this
        )

        //recyclerView->xml에 만들어둔 recuclearView에 layoutManager연결하기
        recyclerView.layoutManager = LinearLayoutManager(this@CallingList2)

    }
}

class RecyclerViewAdapter2(
    val phonelist: ArrayList<callList>,
    val inflater: LayoutInflater,
    val activity: Activity  //RecyclerViewAdapter2는 AppCompatActivity를 상속받지 않고 있으니 startActivity사용 못하니까 엑티비티를 생성자로 받아서
) : RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder2>() {

    inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var story: TextView

        init {
            name = itemView.findViewById(R.id.name)
            story = itemView.findViewById(R.id.story)

            itemView.story.setOnClickListener {
                val intent = Intent(activity, PhoneBook_detail_Activity::class.java)
                intent.putExtra("number", phonelist.get(adapterPosition).number)
                intent.putExtra("name", phonelist.get(adapterPosition).name)
                activity.startActivity(intent)
                //AppCompatActivity를 상속받지 않았기 때문에 그냥 startActivity사용 못함
                //그렇다고 AppCompatActivity를 상속받는건 에러는 안뜨는데 안좋고 난 해당 클래스를 엑티비티로 사용할 생각이 없어 걍 어뎁터로 쓸거임
                //생성자에서 받은 액티비티로 startActivity 사용
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
