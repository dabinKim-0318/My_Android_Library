package com.example.kotlin_study.Android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_study.R

class TabPager_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)
    }
}

class PagerAdapter(
    fragmentManager: FragmentManager, //탭 하면 넘어가는 화면 각각을 프라그먼트로 구성
    val tabCount: Int
) : FragmentStateAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
when(position)
    }

    override fun getItemCount(): Int {
        return tabCount

    }


}