package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

//임포트는 내가 해당 파일에서 가져다 쓸 것 정리하는거고
//이 메인액티비티는 기본으로 상단 2개의 임포트가 디폴트임
//MainActivity는 AppCompatActivity라는 클래스를 상속받았음
//MainActivity에서는 디폴트로 onCreate매서드가 선언되어있음
//onCreate메서드는 매개변수로 Bundle타입의 savedInstanceState변수를 받음
//  super.onCreate(savedInstanceState)는 오버라이딩한 onCreate가 호출될때 AppCompatActivity
//의 onCreate도 호출되도록함
//    setContentView(R.layout.all_test_answer)는 화면을 그려주는 역할
//onCreate는 시스템이 액티비티를 생성할 때 실행되는 것으로 필수적으로 구현해야해서 디폴트로 작성돼있음
// Activity의 전체 수명주기 동안 한번만 발생해야하는 기본 어플리케이션 실행로직 구현
//액티비티가 화면을 그리는 것은=setContentView 액티비티 실행중 한번만 그려놓으면 되니까 onCreate에서 구현
//액티비티가 사라졌다 올라올때도 그려놨던것만 쓰면 되니까.
//oncreate제외 나머지 라이프사이클은 액티비티 라이프사이클에서 필수가 아니라서 개발자가 오버라이딩해야함
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_test_answer)  //맨처음에 그려지는 Activity
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","onStart")
        //final 클래스인 Log에서 static메서드인 d호출, 코틀린은 자동 import기능 제공해서 Log클래스자동으로 임포트됨
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","onDestroy")
    }
}