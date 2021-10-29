package My_Library

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_study.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager2.*

class ViewPager2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        //ViewPager2와 Adapter연결
        val adapter = ViewPager2_Adapter(this, 4)
        viewPager2.adapter = adapter

        //각 탭들이 눌렸을때 작업할 수 있는 기반 코드(없어도 무관하긴함)
        ViewPager2_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                // handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // handle tab unselect
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                // handle tab select
                Toast.makeText(applicationContext, "탭 눌림", Toast.LENGTH_SHORT).show()
            }
        })

        //ViewPager와 Tab을 연결
        TabLayoutMediator(ViewPager2_tab_layout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "탭1"  //탭의 이름이 됨
                1 -> tab.text = "탭2"
                2 -> tab.text = "탭3"
                3 -> tab.text = "탭4"
            }
        }.attach()

    }

    // 추가 ) back 버튼 클릭시 화면 슬라이드 과거로 이동시키기
    override fun onBackPressed() {
        if (viewPager2.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

    //ViewPager2의 Adapter
    class ViewPager2_Adapter(
        fragmentActivity: FragmentActivity,
        val count: Int
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 0) {
                return ViewPager2_Fragment1()
            } else if (position == 1) {
                return ViewPager2_Fragment2()
            } else if (position == 2) {
                return ViewPager2_Fragment3()
            } else {
                return ViewPager2_Fragment1()
            }
        }
    }
}

