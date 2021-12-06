package Thread

import Util.shortToast
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import kotlin.concurrent.thread

class MainThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_thread)

        val workerThread = WorkThread()
        workerThread.start()

        shortToast("시작")

        val workThreadRunnable = Thread(WorkThreadRunnable())
        workThreadRunnable.start()
        Log.d("MainThread", "1")

        //   구현한 인터페이스 내부에 메서드가 하나만 있는 경우 람다식으로 변환 가능
        Thread {
            var i = 0
            while (i < 10) {
                i += 1
                Log.d("WorkerThread", "$i")
            }
        }.start()

        //코틀린에서 제공하는 thread
        thread(start = true) {  //thread안에 파라미터로 start = true를 전달하면 thread()안의 코드블록 실행
            var i = 0
            while (i < 10) {
                i += 1
                Log.d("WorkerThread", "$i")
            }
        }
    }
}