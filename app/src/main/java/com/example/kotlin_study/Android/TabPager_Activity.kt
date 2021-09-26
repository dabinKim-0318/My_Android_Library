package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.kotlin_study.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("one"))
        tab_layout.addTab(tab_layout.newTab().setText("two"))
        tab_layout.addTab(tab_layout.newTab().setText("three"))

        //Adapter 연결하기
        val pagerAdapter = PagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter

      //  Pager와 Tablayout 연결하기
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                // view_pager.setCurrentItem(tab!!.position)
                //이거 해주면 스크롤 형식으로 넘겼을떄
                //프라그먼트에 설정해둔 각기 다른 레이아웃 나오긴 하는데 탭이랑 연결이 안돼있음음
            }

            override fun onTabSelected(tab: TabLayout.Tab?) { //탭이 클릭되었을때 리스너 장착
                view_pager.setCurrentItem(tab!!.position) //해당 탭이 클릭되었을때 탭의 position을 켜라
                //탭 클릭했을때 페이져도 같이 움직이게 해주는 역할
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
//        페이져로 움직엿을때 탭도 같이 움직이게 해주는 역할
//        페이저가 바뀌면 콜백되는 리스너, 페이저가 변경되었을때 tab_layout을 호출해서
//        지금 페이지가 바뀌었으니 tab도 바꾸라고 명령
    }
}

class PagerAdapter(
    fragmentManager: FragmentManager, //탭 하면 넘어가는 화면 각각을 프라그먼트로 구성
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        when (position) {
            0 -> {
                return Fragment_three()
            }
            1 -> {
                return Fragment_one()
            }

            2 -> {
                return Fragment_two()
            }
            else -> {
                return Fragment()
            }
        }
    }

    override fun getCount(): Int {
        return tabCount

    }
}


