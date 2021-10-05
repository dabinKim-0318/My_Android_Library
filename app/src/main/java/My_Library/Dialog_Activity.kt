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

        //   public Builder(@NonNull Context context) { }
        //public class AlertDialog extends AppCompatDialog implements DialogInterface
        binding.bt1.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setIcon(com.example.kotlin_study.R.mipmap.ic_launcher)
            builder.setTitle(resources.getString(com.example.kotlin_study.R.string.title)) //"title"이라고 직접 넣어줘도 되는데 string파일에 넣어두는 습관갖자
            builder.setMessage("message")
            builder.show()
        }

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
        binding.bt3.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 추가 예제")
            builder.setItems(com.example.kotlin_study.R.array.좋아) { dialog, pos ->
                val items = resources.getStringArray(com.example.kotlin_study.R.array.좋아)
                Toast.makeText(applicationContext, items[pos], Toast.LENGTH_LONG).show()  //pos가 아이템에 들어있는 애들 각각의 번지수
            }
            builder.show()
        }


        binding.bt4.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            val selectedItems = ArrayList<String>()
            val items = resources.getStringArray(com.example.kotlin_study.R.array.좋아)
//타이틀넣고 setPositiveButton추가해서 ok버튼 만들기
            builder.setTitle("리스트 추가 예제")
            //여기서부터가 리스트 넣는 코드
            builder.setMultiChoiceItems(com.example.kotlin_study.R.array.좋아, null, OnMultiChoiceClickListener
            { dialog, pos, isChecked ->
                if (isChecked == true) // Checked 상태일 때 추가
                {
                    selectedItems.add(items[pos])
                } else  // Check 해제 되었을 때 제거
                {
                    selectedItems.remove(items[pos])
                }
            })

            builder.setPositiveButton("OK") { dialog, pos ->
                var SeletedItemsString = ""
                for (i in selectedItems.indices) {
                    SeletedItemsString = SeletedItemsString + "/" + selectedItems[i]
                }
                val toast = Toast.makeText(applicationContext, "선택 된 항목은 :$SeletedItemsString", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }

            builder.show()
        }



        binding.bt5.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            val items = resources.getStringArray(com.example.kotlin_study.R.array.좋아)
            val selectedItem = ArrayList<String>()
            //     selectedItem.add(items[0]) //다이어로그 켜지면 디폴트로 선택되어있는 거=>좋아 리스트의 0번째 아이템!


//타이틀넣고 setPositiveButton추가해서 ok버튼 만들기
            builder.setTitle("리스트 추가 예제")
            builder.setPositiveButton("ok") { dialogInterface: DialogInterface, i: Int ->  //OnClickListener 인터페이스를 구현한 익명객체를 넣는듯
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT)
            }

            //여기서부터가 리스트 넣는 코드
            builder.setSingleChoiceItems(com.example.kotlin_study.R.array.좋아, 3, DialogInterface.OnClickListener { dialog, pos ->
                selectedItem.clear()
                selectedItem.add(items[pos])
                Toast.makeText(this, selectedItem[0], Toast.LENGTH_SHORT).show()
            })



            builder.setPositiveButton("OK") { dialog, pos ->
                val toast = Toast.makeText(this, "선택된 항목 : " + selectedItem[0], Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            builder.show()
        }

    }
}
