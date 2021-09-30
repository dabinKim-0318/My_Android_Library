package My_Library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_button_navigation_view.*

class ButtonNavigationView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_navigation_view)

        fun replaceFragment(fragment: Fragment) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.commit()
        }
        replaceFragment(ViewPager2_Fragment1())

        navigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_search -> {
                    replaceFragment(ViewPager2_Fragment1())
                    return@setOnItemSelectedListener true
                }
                R.id.action_settings -> {
                    replaceFragment(ViewPager2_Fragment2())
                    return@setOnItemSelectedListener true
                }
                R.id.action_navigation -> {
                    replaceFragment(ML_Fragment())
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }

        }

    }
}


