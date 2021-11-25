package Recyclerview.AsyncListDiffer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityAsyncListDifferBinding

class AsyncListDifferActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAsyncListDifferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncListDifferBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}