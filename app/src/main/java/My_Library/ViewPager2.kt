package My_Library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_view_pager2.*

class ViewPager2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        val adapter = ViewPager2_Adapter(this, 3)
        viewPager2.adapter = adapter

    }

    // 추가 기능 ) back 버튼 클릭시 화면 슬라이드 과거로 이동시키기
    override fun onBackPressed() {
        if (viewPager2.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

    class ViewPager2_Adapter(
        fragmentActivity: FragmentActivity,
        val count: Int
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 0) {
                return ViewPager2_Fragment1()
            } else if (position == 1) {
                return ViewPager2_Fragment2()
            } else {
                return ViewPager2_Fragment3()
            }
        }
    }
}

