package My_Library

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityEditText2Binding

class EditText_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityEditText2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //EditText를 AutoCompleteTextView로 강제 형변환
        val textView = binding.at as AutoCompleteTextView
        // 만들어두었던 String 배열을 가져옴
        val array: Array<out String> = resources.getStringArray(R.array.좋아)
        //  ArrayAdapter 불러와서 adapter만들어서 AutoCompleteTextView에 연결함
        ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array).also { adapter ->
            textView.setAdapter(adapter)
        }

    }
}