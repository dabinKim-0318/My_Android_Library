package Coroutine

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class CoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)



        with(binding) {
            binding.bvUrl.setOnClickListener {
                pbUrl.visibility = View.VISIBLE

                val url = etUrl.text.toString()
                val bitMap = CoroutineScope(Dispatchers.IO).launch {
                    loadImage(url)
                } as Bitmap
                Log.d("Coroutine","Coroutine")
                ivUrl.setImageBitmap(bitMap)
                pbUrl.visibility = View.INVISIBLE

            }
        }

        Log.d("MainThread","MainThread")
    }
}

//코루틴을 쓸때는 class안에 있는 메서드가 아닌 class밖 함수로 만들어서 사용한다
//이때 함수는 어딘가 소속되어있는 놈이 아닌 탑레벨로 선언해야 한다
//suspend예약어 붙임
suspend fun loadImage(imageUrl: String): Bitmap {
    val url = URL(imageUrl)  //string으로 받은 url을 URL로 변경
    val stream = url.openStream() //url주소로 받아놓은걸 스트림으로 열게됨
    return BitmapFactory.decodeStream(stream)  //비트맵 팩토리를 사용하면 스트림으로 받은 이미지 데이터를 비트맵으로 변환함
}


/*
//어떤 스레드에서 동작시킬지 디스패처로 명시함,
// 안드로이드 기본 스레드에ㅔ서 코루틴 실행하고 ui와 상호작용에 최적,
// 텍스트뷰에 글자를 입력해야할경우 Main컨덱스트 사용
//메인스레드이자 ui를 다룰수 있는 영역있데 이 스코프 밖의 메인스레드랑 다른 코루틴만의 메인스레드라고 생각
with(binding) {
    binding.bvUrl.setOnClickListener {
        CoroutineScope(Dispatchers.Main).launch {
            pbUrl.visibility = View.VISIBLE  //다운로드 버튼 클릭시 프로그레스바가 보이도록
            val url = etUrl.text.toString() //url얻어서 string으로 변환
            //loadImage(url)   //Main디스패처에서는 이미지 다운로드 파일 입출력같은 일을 할 수 없음
            val bitMap = withContext(Dispatchers.IO) {
                loadImage(url)
                //IO를 수행할 수 있는 코루틴 스코프를 분리해서 따로 만들어서 실행해야함
                //loadImage의 반환값은 withContext의 반환값으로도 쓸수있음
            }
            //io영역=코루틴의 백그라운드 쓰레드가 끝나면 다시 포그라운드 나가서 UI 조작 해줌
            ivUrl.setImageBitmap(bitMap)
            pbUrl.visibility = View.INVISIBLE
        }
    }
}
}
}

//코루틴을 쓸때는 class안에 있는 메서드가 아닌 class밖 함수로 만들어서 사용한다
//이때 함수는 어딘가 소속되어있는 놈이 아닌 탑레벨로 선언해야 한다
//suspend예약어 붙임
suspend fun loadImage(imageUrl: String): Bitmap {
    val url = URL(imageUrl)  //string으로 받은 url을 URL로 변경
    val stream = url.openStream() //url주소로 받아놓은걸 스트림으로 열게됨
    return BitmapFactory.decodeStream(stream)  //비트맵 팩토리를 사용하면 스트림으로 받은 이미지 데이터를 비트맵으로 변환함*/
