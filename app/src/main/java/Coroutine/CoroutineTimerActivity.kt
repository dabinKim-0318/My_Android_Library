package Coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.databinding.ActivityTimerBinding
import kotlinx.coroutines.*

class CoroutineTimerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimerBinding
    var before = 0
    var after = 0
    var started = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        //핸들러 만들어서 백그라운드 스레드와 메인 스레드가 통신하자
//        val handler = object : Handler(Looper.getMainLooper()) {
//            override fun handleMessage(msg: Message) {  //메시지가 담고 있는 내용에 따라 핸들러 호출
//                val minute = String.format("%02d", after / 60)
//                val second = String.format("%2d", after % 60)
//                binding.tvTime.setText("${minute}:${second}")
//            }
//        }

        binding.bvStart.setOnClickListener {
            Toast.makeText(this, "시작", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                while (before !== after) {
                    val minute = String.format("%02d", after / 60)
                    val second = String.format("%2d", after % 60)

                    binding.tvTime.setText("${minute}:${second}")
                    Log.d("setText", "setText")
                }

                withContext(Dispatchers.Default) {
                    while (started) {
                        Log.d("setText", "setText")
                        delay(1000)
                        if (started) {
                            before = after //0 1 2
                            after = before + 1 //1  2 3
                        }
                    }
                }
            }
//            thread(start = true) {
//                while (started) {
//                    Thread.sleep(1000)
//                    if (started) {
//                        total += 1
//                        handler.sendEmptyMessage(0) //루퍼에게 메시지 전달해서 메시지 큐에 넣음
//                        //어차피 sendEmptyMessage에 의해 실행되는 handleMessage는 전역변수인 total을 가지고실행되니까 아무 메시지 전달 안함
//                    }
//                }
//            }

        }

        binding.bvStop.setOnClickListener {
            started = !started
            before = 0
            binding.tvTime.setText("00:00")
        }

    }


}
