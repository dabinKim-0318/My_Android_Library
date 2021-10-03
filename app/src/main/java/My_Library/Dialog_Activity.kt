package My_Library

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityDialogBinding


class Dialog_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bt1.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setIcon(com.example.kotlin_study.R.mipmap.ic_launcher)
            builder.setTitle(resources.getString(com.example.kotlin_study.R.string.title))
            builder.setMessage("message")
            builder.show()
        }

        binding.bt2.setOnClickListener {

            var builder = AlertDialog.Builder(this)
            builder.setIcon(com.example.kotlin_study.R.mipmap.ic_launcher)
            builder.setTitle(resources.getString(com.example.kotlin_study.R.string.title))
            builder.setMessage("message")


            builder.setPositiveButton("Positive") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT)
            }
            builder.setNegativeButton("Negative") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT)
            }
            builder.setNeutralButton("Neutral") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "하이", Toast.LENGTH_SHORT)
                val intent = Intent(this, Spinner_RadioButton::class.java)
                startActivity(intent)
            }
            builder.show()


        }

        binding.bt3.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 추가 예제")
            builder.setItems(R.array.좋아) { dialog, pos ->
                val items = resources.getStringArray(R.array.좋아)
                Toast.makeText(applicationContext, items[pos], Toast.LENGTH_LONG).show()
            }
            builder.show()
        }

    }
}

//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
//                @Override
//                public void onClick(DialogInterface dialog, int id)
//                {
//                    Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
//                }
//            });
//            builder.setPositiveButton("OK") { dialog, id -> Toast.makeText(applicationContext, "OK Click", Toast.LENGTH_SHORT).show() }
