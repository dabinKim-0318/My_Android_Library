package com.example.kotlin_study.Android

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R

class CarForList(val name: String, val engine: String) {}

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view2)

        //아이템 리스트 준비
        val carList = mutableListOf<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList(" $i 번째 자동차", "$i 번째 순위"))
        }
//        val textView: TextView =findViewById(R.id.hello)
//        findViewById가 id가 hello인 문자열과 동일하면서, 속성이textView인 view를 찾아서 리턴

//        public <T extends View > T findViewById(@IdRes int id) {
//            return getDelegate().findViewById(id);
//        }
        //val container= findViewById<LinearLayout>(R.id.addview_container)

        val container:LinearLayout = findViewById(R.id.addview_container)  //이 container역할을 하는 LinearLayout에 리스트를 주루룩 넣어서 스크롤뷰로 감쌀거야




        //   val inflater=this@AddViewActivity.layoutInflater
//        public abstract class LayoutInflater {
//            public static LayoutInflater from(Context context)
//        }

        val inflater = LayoutInflater.from(this@AddViewActivity)
        for (i in 0 until carList.size) {
           val itemView= inflater.inflate(R.layout.item_view, null, true)
            val carNameView=itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView=itemView.findViewById<TextView>(R.id.car_engine)

            carNameView.setText(carList.get(i).name)
            carEngineView.setText(carList.get(i).engine)
            container.addView(itemView)
        }

    }
}