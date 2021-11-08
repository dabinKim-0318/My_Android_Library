package Thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityTimerBinding
import kotlin.concurrent.thread

class TimerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimerBinding
    var total = 0
    var started = true

    //핸들러 만들어서 백그라운드 스레드와 메인 스레드가 통신하자
    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {  //메시지가 담고 있는 내용에 따라 핸들러 호출
            val minute = String.format("%02d", total / 60)
            val second = String.format("%2d", total % 60)

            binding.tvTime.setText("${minute}:${second}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bvStart.setOnClickListener {
            thread(start = true) {
                while (started) {
                    Thread.sleep(1000)
                    if (started) {
                        total += 1
                        handler.sendEmptyMessage(0) //루퍼에게 메시지 전달해서 메시지 큐에 넣음
                        //어차피 sendEmptyMessage에 의해 실행되는 handleMessage는 전역변수인 total을 가지고실행되니까 아무 메시지 전달 안함
                    }
                }
            }
        }
        binding.bvStop.setOnClickListener {
            started = !started
            total = 0
            binding.tvTime.setText("00:00")
        }

    }
}