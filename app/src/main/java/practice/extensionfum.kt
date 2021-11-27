package practice

import android.content.Context
import android.widget.Toast


    //Context 클래스를 확장하는데 토스트는 항상 첫 인자로 Context를 넣어주니까
//Context클래스 타입 안에서 확장시키면 context는 간단히 그 안에서 넣어주니까
    fun Context.shortToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
