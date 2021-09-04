package com.example.kotlin_study.Android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("lifecycle", "onCreate")

        val fragmentOne: Fragment = Fragment()

        val bundle:Bundle=Bundle()
        bundle.putString("hello","hello")
        fragmentOne.arguments=bundle

        button.setOnClickListener {
            // public FragmentManager getSupportFragmentManager() {
            //        return mFragments.getSupportFragmentManager();
            //    }
           // val fragmentOne: Fragment = Fragment()  //프라그먼트를 하나 만든다(xml에서 만들기 할때 만들었던 프라그먼트 사용)
            val fragmentManager: FragmentManager = supportFragmentManager  //AppCompatActivity클래스가 가진 메서드라서 상속했으니까 바로 사용 가능

            //Transaction만들기:Transaction은 작업단위이며 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() //해당 코드가 호출되는 순간 Transaction을 시작하겠다
            //시작했으니까 할일을 적는다:replay()의 첫번째인자로
            // 바꾸고싶은 뷰아이디를 적고 두번째인자로 바꿀 프라그먼트를 적음
            //뷰아이디자리에 프라그먼트가 오게되는것
            //여기서 viewid는 xml파일에 만들어두었던 id가 container인 뷰
            fragmentTransaction.replace(R.id.container, fragmentOne)

            //Transaction을 끝내주자
            //끝을 내는 방법엔 2개가 있음 commit(), commitnow():commitnow는 시스템한테 트랜젝션
            //만들었는데 container랑 내가만든 프라그먼트랑 지금 당장 바꾸라는 것. 과부화 올수도
            //commit은 시스템이 시간 있을때 하거라.. 보통 commit사용하는게 안정적
            fragmentTransaction.commit()
        }

        button2.setOnClickListener{
           // val fragmentOne=Fragment()
            val fragmentManager=supportFragmentManager
            val fragmentTransaction= fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragmentOne)
            // fragmentTransaction.remove(fragmentOne)  //나와라 버튼 누르면 다시 붙일 수 있음
            fragmentTransaction.commit()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "onStart")
        //final 클래스인 Log에서 static메서드인 d호출, 코틀린은 자동 import기능 제공해서 Log클래스자동으로 임포트됨
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "onDestroy")
    }
}
