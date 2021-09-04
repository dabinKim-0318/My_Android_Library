package com.example.kotlin_study.Android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_open_internet_page1.*


class Open_InternetPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlin_study.R.layout.activity_open_internet_page1)


        open.setOnClickListener {
            var resulturl = write.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resulturl))
            startActivity(intent)

        }

        write.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit","beforeTextChanged:"+p0)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit","onTextChanged:"+p0)
            }
            override fun afterTextChanged(p0: Editable?) {
                Log.d("edit","afterTextChanged:"+p0)
                if(p0.toString()=="abc"){    Log.d("edit","text is edit abc")}
            }
        })
    }
}

//public Editable getText() {

//public abstract class Uri implements Parcelable, Comparable<Uri>
//public static Uri parse(String uriString) {
//    throw new RuntimeException("Stub!");
//}

//public interface TextWatcher extends NoCopySpan {
//    void beforeTextChanged(CharSequence var1, int var2, int var3, int var4);
//
//    void onTextChanged(CharSequence var1, int var2, int var3, int var4);
//
//    void afterTextChanged(Editable var1);
//}