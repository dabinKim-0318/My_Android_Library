package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)


        tab_layout.addTab(tab_layout.newTab().setText("4"))
        tab_layout.addTab(tab_layout.newTab().setText("two"))
        tab_layout.addTab(tab_layout.newTab().setText("three"))
    }
}

class PagerAdapter(
    fragmentManager: FragmentManager, //탭 하면 넘어가는 화면 각각을 프라그먼트로 구성
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment()
            }
            1 -> {
                return Fragment()
            }

            2 -> {
                return Fragment()
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