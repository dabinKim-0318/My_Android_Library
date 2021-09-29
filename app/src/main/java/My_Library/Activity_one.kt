package My_Library

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_one.*

class Activity_one : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        Activity_one_Button.setOnClickListener {
            val intent = Intent(this@Activity_one, Activity_two::class.java)
            startActivity(intent)
        }

    }
}