package My_Library

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_edit_text.*

class Spinner_RadioButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        val items = arrayOf("아이템0", "아이템1", "아이템2", "아이템3", "아이템4")
        val Adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = Adapter



        spinner.setSelection(2) // 2번째 포지션으로 이동합니다.
        spinner.prompt="주소선택"  //다이어로그일때 제목 띄우기

        //spinner Adapter구현현
       spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
                when (position) {
                    0 -> {

                    }
                    1 -> {

                    }
                    //...
                    else -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        radio_group.setOnCheckedChangeListener { group, checkedid ->
            when (checkedid) {
                R.id.sameday -> hi.setText("sameday")
                R.id.nextday -> hi.setText("nextday")
                R.id.pickup -> hi.setText("pickup")
            }
        }

    }
}


//        fun onRadioButtonClicked(view: View) {
//            if (view is RadioButton) {
//                // Is the button now checked?
//                val checked = view.isChecked
//
//                // Check which radio button was clicked
//                when (view.getId()) {
//                    R.id.sameday ->
//                        if (checked) {
//                            Toast.makeText(this,"dfds",Toast.LENGTH_SHORT)
//                        }
//                    R.id.nextday ->
//                        if (checked) {
//                            // Ninjas rule
//                        }
//                    R.id.pickup ->
//                        if (checked) {
//                            // Ninjas rule
//                        }
//                }
//            }
//        }