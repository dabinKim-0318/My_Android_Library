package My_Library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivitySampleFragmentBinding

class SampleFragment_Activity : AppCompatActivity() {
    private var position = FRIST_POSITION

    //분기처리 자바의 상수만들기와 같은..
    companion object {
        const val FRIST_POSITION = 1
        const val SECOND_POSITION = 2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment1 = SampleFragment()
        val fragment2 = SampleFragment2()

        supportFragmentManager.beginTransaction().add(R.id.container_sample, fragment1) //프래그먼트1 넣어두고 시작


        binding.btsChange.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            //setonclicklistener코드 밖에썼더니 안됨: transaction호출할때마다 beginrtansaction얻어야하는군
            when (position) {
                FRIST_POSITION -> {
                    fragmentTransaction.replace(R.id.container_sample, fragment1)
                    position = SECOND_POSITION
                }
                SECOND_POSITION -> {
                    fragmentTransaction.replace(R.id.container_sample, fragment2)
                    position = FRIST_POSITION
                }
            }

            fragmentTransaction.commit()


        }

    }
}