package My_Library

import android.content.DialogInterface
import android.content.DialogInterface.OnMultiChoiceClickListener
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityDialogBinding


class Dialog_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

//1.text+title
        binding.bt1.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setIcon(com.example.kotlin_study.R.mipmap.ic_launcher)
            builder.setTitle(resources.getString(com.example.kotlin_study.R.string.title)) //"title"이라고 직접 넣어줘도 되는데 string파일에 넣어두는 습관갖자
            builder.setMessage("message")
            builder.show()
        }
//2.text+title+밑에 버튼 3개
        binding.bt2.setOnClickListener {

            var builder = AlertDialog.Builder(this)
            builder.setIcon(com.example.kotlin_study.R.mipmap.ic_launcher)
            builder.setTitle(resources.getString(com.example.kotlin_study.R.string.title))
            builder.setMessage("message")

            //  public interface DialogInterface
            // public Builder setPositiveButton(CharSequence text, final OnClickListener listener)

            builder.setPositiveButton("Positive") { dialogInterface: DialogInterface, i: Int ->  //OnClickListener 인터페이스를 구현한 익명객체를 넣는듯
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Negative") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Neutral") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Spinner_RadioButton::class.java)
                startActivity(intent)
            }
            builder.show()


        }
         //  public Builder setItems(@ArrayRes int itemsId, final OnClickListener listener)
//3.spinner처럼 리스트로 보여주고 하나 선택
        binding.bt3.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 추가 예제")
            builder.setItems(com.example.kotlin_study.R.array.좋아) { dialog, pos ->
                val items = resources.getStringArray(com.example.kotlin_study.R.array.좋아)
                Toast.makeText(applicationContext, items[pos], Toast.LENGTH_LONG).show()  //pos가 아이템에 들어있는 애들 각각의 번지수
            }
            builder.show()
        }

//4.체크박스로 여러개 선택
        binding.bt4.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            val selectedItems = ArrayList<String>()  //체크박스로 클릭한 아이템 리스트로 저장
            val items = resources.getStringArray(com.example.kotlin_study.R.array.좋아) //만들어둔 리스트 가져오기


            //타이틀넣고 setPositiveButton추가해서 ok버튼 만들기
            builder.setTitle("리스트 추가 예제")
            //여기서부터가 체크박스 정의하는 부분
            builder.setMultiChoiceItems(com.example.kotlin_study.R.array.좋아, null, OnMultiChoiceClickListener
            { dialog, pos, isChecked ->
                if (isChecked == true) // Checked 상태일 때 추가
                {
                    selectedItems.add(items[pos])  //선택된 아이템을 만들어둔 리스트에서 번지로 꺼내옴
                } else  // Check 해제 되었을 때 제거
                {
                    selectedItems.remove(items[pos])
                }
            })

            builder.setPositiveButton("OK") { dialog, pos ->
                var SeletedItemsString = ""
                for (i in selectedItems.indices) {  // 컬렉션에서 데이터 위치를 나타내는 인덱스값을 이용
                    SeletedItemsString = SeletedItemsString + "/" + selectedItems[i]
                }
                val toast = Toast.makeText(this, "선택 된 항목은 :$SeletedItemsString", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0) //토스트 띄우는 위치 조정
                toast.show()
            }

            builder.show()
        }


//5.라디오버튼으로 하나 선택
        binding.bt5.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            val items = resources.getStringArray(com.example.kotlin_study.R.array.좋아)
            val selectedItem = ArrayList<String>()
            selectedItem.add(items[0]) //다이어로그 켜지면 디폴트로 선택되어있는 거=>좋아 리스트의 0번째 아이템! 이거 안해주면 아무것도 선택안하고 다이어로그 껏을때 null이라 에러남


//타이틀넣고 setPositiveButton추가해서 ok버튼 만들기
            builder.setTitle("리스트 추가 예제")


            //여기서부터가 리스트 넣는 코드
            builder.setSingleChoiceItems(com.example.kotlin_study.R.array.좋아, 0, DialogInterface.OnClickListener { dialog, pos ->
                selectedItem.clear()
                selectedItem.add(items[pos])  //라디오 버튼 누를때마다 기존 [0]에 있던 아이템 사라지고 들어가고..selectedItem는 계속 0번째 인덱스의 벨류만 바뀜
                Toast.makeText(this, selectedItem[0], Toast.LENGTH_SHORT).show()
            })



            builder.setPositiveButton("OK") { dialog, pos ->
                val toast = Toast.makeText(this, "선택된 항목 : " + selectedItem[0], Toast.LENGTH_LONG)  //결과적으로 인덱스 0번째의 벨류만 리스트에 있겟지
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            builder.show()
        }

    }
}
