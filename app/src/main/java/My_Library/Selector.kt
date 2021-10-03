package My_Library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivitySelectorBinding

class Selector : AppCompatActivity() {
    val binding = ActivitySelectorBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.heart.setOnClickListener {
            binding.heart.toggle()
        }


    }
}