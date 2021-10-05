package My_Library

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityDialogTestBinding


class Dialog_test : AppCompatActivity() {

    private val list: CharSequence? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityDialogTestBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        OnClickHandler(this)
    }

    fun OnClickHandler(activity: Activity) {
        val dialogView: View = getLayoutInflater().inflate(com.example.kotlin_study.R.layout.activity_dialog_test, null)
        val nameEditText = dialogView.findViewById(com.example.kotlin_study.R.id.name) as EditText
        val NicknameEditText = dialogView.findViewById(com.example.kotlin_study.R.id.nickname) as EditText
        var builder = AlertDialog.Builder(activity)
        builder.setView(dialogView)
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, pos ->
            val name = "이름은 : " + nameEditText.text.toString()
            val nickname = "별명은 : " + NicknameEditText.text.toString()
            Toast.makeText(
                activity, """
     $name
     $nickname
     """.trimIndent(), Toast.LENGTH_LONG
            ).show()
        })
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}


