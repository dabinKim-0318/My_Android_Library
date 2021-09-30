package My_Library

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_check_box.*

class CheckBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
        var story: String = ""
        fun addStory(checkbox: String) {
            story += checkbox
        }

        var listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView.id) {
                    R.id.checkbox1 -> {
                        Toast.makeText(this@CheckBox, "1", Toast.LENGTH_SHORT).show()
                        addStory("아메리카노")
                    }
                    R.id.checkbox2 -> {
                        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
                        addStory("라떼")
                    }
                    R.id.checkbox3 -> {
                        Toast.makeText(this, "3", Toast.LENGTH_LONG).show()
                        addStory("디카페인")
                    }
                }
            } else {
            }
        }

        checkbox1.setOnCheckedChangeListener(listener)
        checkbox2.setOnCheckedChangeListener(listener)
        checkbox3.setOnCheckedChangeListener(listener)



        show.setOnClickListener {
            Toast.makeText(this, "$story", Toast.LENGTH_SHORT).show()
        }

    }
}


//checkbox1.setOnCheckedChangeListener { buttonView, isChecked ->
//    if (isChecked) {    Toast.makeText(this@CheckBox, "1", Toast.LENGTH_SHORT).show()
//    } else {
//    }
//}
//checkbox2.setOnCheckedChangeListener { buttonView, isChecked ->
//    if (isChecked) {    Toast.makeText(this@CheckBox, "2", Toast.LENGTH_SHORT).show()
//    } else {
//    }
//}
//checkbox3.setOnCheckedChangeListener { buttonView, isChecked ->
//    if (isChecked) {    Toast.makeText(this@CheckBox, "3", Toast.LENGTH_SHORT).show()
//    } else {
//    }
//}