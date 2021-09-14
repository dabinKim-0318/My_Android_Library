package com.example.kotlin_study.Android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //리스트뷰에 얹고 싶은 리스트 만들기
        val carList = ArrayList<CarForList>()
        for (i in 0 until 30) {
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, this@ListViewActivity)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity, carName + " " + carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

//BaseAdapter을 상속받아 Adapter 구현
//사용자의 데이터를 받아 뷰(View)를 생성해주는 객체로 ListView와는 독립적으로 동작하는 객체입니다.
//ListView는 Adpater로부터 생성된 뷰(View)를 받아 ListView의 한 항목으로 배치
class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        return carForList.size
        //adapter가 아이템의 개수를 알아야 화면에 그릴 아이템 개수 조절 가능
        //그리고자 하는 아이템 리스트에서의 아이템 전체갯수
    }

    override fun getItem(p0: Int): Any {
        return carForList.get(p0)
        //p0은 listView의 순서임 해당 인덱스에 해당하는 아이템 정보 알려줌
        //그리고자 하는 아이템 리스트의 하나(포지션에 해당하는는
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
        //아이디를 포지션으로 해주겠다=포지션은 listView의 아이템의 인덱스
        //해당 포지션에 위치한 아이템 뷰의 아이디 설정정
    }

    //p0:position, p1:convertView, p2:parent
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val layoutInflater = LayoutInflater.from(context)
//        var view = layoutInflater.inflate(R.layout.item_view, null)
//
//
//        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.setText(carForList.get(p0).name)  //p0은 positon임
//        carEngineTextView.setText(carForList.get(p0).engine)
//        return view  //container.addView()가 없이 그냥 view객체를 던짐


        //------------------ViewHolder에 담아두고 써보자-------------------
        val layoutInflater = LayoutInflater.from(context)

        val view: View
        val holder: ViewHolder

        if (p1 == null) {
            Log.d("convert", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        } else {
            Log.d("convert", "2")
            holder = p1.tag as ViewHolder
            view = p1
        }
        holder.carName?.setText(carForList.get(p0).name)
        holder.carEngine?.setText(carForList.get(p0).engine)
        return view
    }

}

class ViewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}


//findViewId는 계속 view에서 해당하는 id를 찾아야하는데 사용자 정의 데이터 수만큼 돌면서 계속 id를
//찾아야 해서 비효율적임임 resource사용 많이함->ViewHolder을 만들어놓고 여기에 id를 넣어두고 사용할수잇음


