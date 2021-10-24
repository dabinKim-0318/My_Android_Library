package Splash

import My_Library.ViewPager2
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R

class PumkinSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pumkin_splash2)

        startLoading()

    }

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