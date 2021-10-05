package My_Library

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityDialogTestBinding


class Dialog_Custom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityDialogTestBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val dialog = Dialog(this)     // Dialog 초기화
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀 제거
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.Transparent.toArgb()))  //둥근테두리로 만들려고 background를 투명하게
        dialog.setContentView(R.layout.dialog_open)             // xml 레이아웃 파일과 연결(다이어로그 레이아웃)
        dialog.setCancelable(false)  // 다이얼로그외에 다른 화면을 눌렀을 때 나가는 것 방지

        // dialog01을 디자인하는 함수
        fun showDialog01() {
            dialog.show(); // 다이얼로그 띄우기

            // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

            // 아니오 버튼
            val noBtn = dialog.findViewById<Button>(R.id.noBtn)
            noBtn.setOnClickListener {
                Toast.makeText(this, "네", Toast.LENGTH_SHORT).show()
                dialog.dismiss() //토스트 띄우고 다이어로그 사라지게
            }


            // 네 버튼
            val yesBtn = dialog.findViewById<Button>(R.id.yesBtn)
            yesBtn.setOnClickListener {
                Toast.makeText(this, "아니오", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CollapsingToolbarLayout_Activity::class.java)
                startActivity(intent)
            }


        }


        // 버튼: 커스텀 다이얼로그 띄우기
        binding.showBtn.setOnClickListener {
            showDialog01()

        }


    }
}




