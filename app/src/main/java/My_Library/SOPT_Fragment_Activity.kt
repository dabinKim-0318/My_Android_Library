package My_Library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivitySoptFragmentBinding

class SOPT_Fragment_Activity : AppCompatActivity() {
    private lateinit var binding: ActivitySoptFragmentBinding

    private var position = FIRST_POSITION

    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoptFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactionFragment()
    }


    fun transactionFragment() {
        val fragment1 = SOPT_Fragment()
        val fragment2 = SOPT_Fragment2()

        binding.bvFragment.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            when (position) {
                FIRST_POSITION -> {
                    transaction.replace(R.id.container, fragment1)
                    position = SECOND_POSITION
                }
                SECOND_POSITION -> {
                    transaction.replace(R.id.container, fragment2)
                    position = FIRST_POSITION
                }

            }
            transaction.commit()
        }

    }

}