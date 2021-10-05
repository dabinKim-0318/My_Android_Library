package My_Library

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityDialogDollBinding

class Dialog_Doll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDialogDollBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fun toast() {
            Toast.makeText(this, "Ddd", Toast.LENGTH_SHORT).show()
        }

        val dialog = Dialog(this)     // Dialog 초기화
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀 제거
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.Transparent.toArgb()))  //둥근테두리로 만들려고 background를 투명하게
        dialog.setContentView(R.layout.dialog_doll_2)// xml 레이아웃 파일과 연결(다이어로그 레이아웃 아닌거 주의!)


        fun mydialog() {
            dialog.show()
            val et_id_in = dialog.findViewById<EditText>(R.id.et_id_in)
            val size = dialog.findViewById<TextView>(R.id.size)

            et_id_in.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) { }
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    var userinput = et_id_in.text.toString()
                    size.text = userinput.length.toString() + " / 100"
                }
            })
            val appCompatButton = dialog.findViewById<Button>(R.id.appCompatButton)
            appCompatButton.setOnClickListener {
                toast()
            }

        }

        binding.bvOk.setOnClickListener {
            mydialog()

        }


    }


}
