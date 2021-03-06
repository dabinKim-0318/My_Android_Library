package Splash

import My_Library.ViewPager2
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityPumkinSplash2Binding

class PumkinSplash : AppCompatActivity() {
    private lateinit var binding: ActivityPumkinSplash2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPumkinSplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        startLoading()
    }
    //

    private fun startLoading() {
        val handler = Handler()
        handler.postDelayed({
            var intent = Intent(this, ViewPager2::class.java)
            startActivity(intent)
        }, SPLASH_VIEW_TIME)
    }

    companion object {
        const val SPLASH_VIEW_TIME = 2000L
    }
}