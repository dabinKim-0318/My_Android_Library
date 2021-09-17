package com.example.kotlin_study.Android

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import java.util.*
import kotlin.collections.ArrayList

class BingActivity : AppCompatActivity() {
    val BallList = ArrayList<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bing)

        for (item in 0..15) {
            var bmp: Int = getResources().getIdentifier("bing_" + (item + 1), "drawable", packageName)
            var bitmap: Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), bmp), 70, 70, false)
            BallList.add(bitmap)


        }


        val btn: Button = findViewById<Button>(R.id.start_button)
        btn.setOnClickListener {
            Toast.makeText(this@BingActivity, "button start.", Toast.LENGTH_SHORT).show()
            var set: TreeSet<Int> = TreeSet()
            while (set.size < 4) {
                val random = Random()
                val num = random.nextInt(16)
                set.add(num)
            }

            var nCount = 0
            for (i in set) {
                var tmpID: Int = getResources().getIdentifier("ballView" + (nCount + 1), "id", packageName)
                val imgView = findViewById<ImageView>(tmpID)
                imgView.setImageBitmap(BallList.get(i))
                nCount++
            }

        }


    }
}