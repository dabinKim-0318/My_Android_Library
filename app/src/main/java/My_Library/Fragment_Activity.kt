package My_Library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_fragment2.*

class Fragment_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2)

        val fragment = ML_Fragment()

        come.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTranaction = fragmentManager.beginTransaction()
            fragmentTranaction.replace(R.id.container, fragment)
            fragmentTranaction.commit()
        }
        out.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTranaction = fragmentManager.beginTransaction()
            fragmentTranaction.remove(fragment)
            fragmentTranaction.commit()
        }
    }
}