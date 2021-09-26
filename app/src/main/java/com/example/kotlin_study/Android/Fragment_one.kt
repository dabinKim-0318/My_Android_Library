package com.example.kotlin_study.Android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_study.R

//Activity에서가 아니라 새로운 kt파일에 Fragment를 만든다
//Fragment 클래스를 상속받아서 class하나 만들면 fragment만든거임
//11개의 프레그먼트 수명주기 메서드를 오버라이딩함
//Activity파일에서 Activity수명주기 메서드도 오버라이딩함
//프라그먼트 수명주기에도 수명주기 호출하면 로그 찍힐수있도록 로그넣어줌
//내가 밑에 만들어둔 Fragment가 xml파일에있는 id가 fragment_One인 영역(View)을 차지하게 될 것임
//프래그먼트 수명주기 중 onCreatView가 호출될때 프래그먼트의 UI를 그리게됨(프라그먼트가 인터페이스를 처음 그릴때 호출됨)됨
//Activity는 ui그릴때 oncreate호출될때 그려졌던거랑 다르군


class Fragment_one : Fragment() {
    override fun onAttach(context: Context) {
        Log.d("lifecycle", "F onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("lifecycle", "F onCreate")
        super.onCreate(savedInstanceState)
    }

    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.all_test_answer)  //맨처음에 그려지는 Activity
//    }
    //inflater는 view를 그려주는 역할이고 container는 지금 만드는 프라그먼트는 결국 xml에 있는 위젯(뷰 컴포넌트)인
    //id가 fragment_One인 위젯에 들러붙게되는건데 얘를 감싸고 있는 부모뷰인 LinearLayout의 자식 뷰로써 갖다 붙여짐
    //그래서 container는 내가 들러붙을 곳을 써줘야되는거다 즉 부모 view를 써줘야됨
    //inflate로 view그린거 넣기: xml파일로 view를 만들어서 그 xml파일경로를 넣어줘야됨
    //layout에서 fragment_one.xml 파일 하나 만들자
    //이제 view그릴때 뭔 리소스 쓸지 inflate()인자로 넣어주자
    //inflate의 두번째 인자로 어디에 붙을건지 넣어주자 container에 붙겠지
    //onCreateView는 View를 리턴해야하는데 inflate()가 View를 리턴하므로 해당 코드를 리턴
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle", "F onCreateView")
        return  inflater.inflate(R.layout.activity_1,container,false)
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("lifecycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("lifecycle", "F onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        val data=arguments?.getString("hello")
        Log.d("data","data")
    }

    override fun onStart() {
        Log.d("lifecycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("lifecycle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("lifecycle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("lifecycle", "F onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("lifecycle", "F onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("lifecycle", "F onDetach")
        super.onDetach()
    }

}