package com.example.kotlin_study.Android

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        //SharedPreference를 불러와보자

        //Mode
        //1.MODE_PRIVATE:생성한 어플리케이션에서만 사용가능, 지금 내가 만든 앱에서만 사용
        //2.MODE_WORLD_READABLE:다른 어플리케이션에서 사용가능+읽기만 가능
        //3.MODE_WORLD_WRITEABLE:다른 어플리케이션에서 사용가능+읽기+기록
        // EX.카카오-카카오뱅크에서 처럼 두 앱이 데이터를 상호작용해야하는 경우
        //4.MODE_MULTI_PROCESS:이미 호출되어 사용중인지 체크
        //5.MODE_APPEND:기존 preference에 신규로 추가

        //sp1->SharedPreferences
        //     (Key,Value)로 ("hello", "안녕하세요") 가짐
        //sp2->SharedPreferences
        //     (Key,Value)로 ("hello", "안녕하세요") 가짐
        //sp1, sp2는 독립적인 저장공간이기때문에 서로 영향 주지 않음!!
        //sharedPreference에 데이터를 넣기 위해 editor 얻어오기

        save_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")  //key-value값으로 저장
            editor.putString("goodbye", "안녕히가세요")  //key-value값으로 저장
            editor.commit()  //커밋까지 해야 데이터 완전히 들어감
        }

//앱이 실행될때 위에서 sharedPreference의 sp1에 안녕하세요 저장시켰으니까 버튼 클릭시 데이터 꺼내와보자
        load_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음1") //key가 hello로 저장된 value값을 꺼내고 없으면 "데이터 없음"이 디폴트 값으로 출력
            val value2 = sharedPreference.getString("goodbye", "데이터 없음2") //key가 hello로 저장된 value값을 꺼내고 없으면 "데이터 없음"이 디폴트 값으로 출력
            Log.d("key-value", "value1:" + value1)
            Log.d("key-value", "value2:" + value2)

        }

        delete_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }

        delete_all_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}