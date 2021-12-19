package Recyclerview

import Recyclerview.base.DiffUtilRecyclerView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_study.databinding.ActivityRecyclerView3Binding

class DiffUtilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerView3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerView3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val myRecyclerViewAdapter = DiffUtilRecyclerView()
        val oldList = listOf(
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
        )
        val newList = listOf(
            Data("1"),
            Data("1"),
            Data("1"),
            Data("1"),
            Data("3"),
            Data("3"),
            Data("3"),
            Data("1"),
            Data("1"),
        )
        myRecyclerViewAdapter.followerList.addAll(oldList)
        binding.rv.adapter = myRecyclerViewAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)
        val diffUtil = BaseDiffUtil(oldList, newList) //예전거랑 지금거 비교해
        val diffResult = DiffUtil.calculateDiff(diffUtil) //업데이트 필요한 리스트 찾아

     /*   //찾아놨지? 이제 기존 리스트 클리어하고
        myRecyclerViewAdapter.followerList.clear()
        //새 리스트 넣은 다음에
        myRecyclerViewAdapter.followerList.addAll(newList)*/
        // 교체가 필요한 아이템에 대해서 부분적으로 데이터를 교체하라는 notify를 실행해서 adapter에게 알림
        diffResult.dispatchUpdatesTo(myRecyclerViewAdapter)
    }
}