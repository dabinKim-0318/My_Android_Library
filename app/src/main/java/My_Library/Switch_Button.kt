package My_Library

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivitySwitchButtonBinding

class Switch_Button : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySwitchButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sw1.setOnCheckedChangeListener { CompoundButton, onSwitch ->

            //  스위치가 켜지면
            if (onSwitch) {
                Toast.makeText(this, "switch on", Toast.LENGTH_SHORT).show()
            }

            //  스위치가 꺼지면
            else {
                Toast.makeText(this, "switch off", Toast.LENGTH_SHORT).show()
            }
        }

    }
}