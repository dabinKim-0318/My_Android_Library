package Recyclerview.ListAdapter

import Recyclerview.Data
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_study.databinding.ActivityAsyncListDifferBinding

class ListAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAsyncListDifferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncListDifferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myRecyclerViewAdapter = ListAdapterRecyclerView()
        val oldList = listOf(
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

        //submitList(MutableList<T> list) : 리스트 항목을 변경하고 싶을 때 사용합니다
        //리스트가 변경될 때 반응하여 어댑터에 list를 넘겨줍니다
        myRecyclerViewAdapter.submitList(newList)

/*        // 뷰모델(데이터 저장하는 곳)에서 리스트가 변경될 때 반응하여 어댑터에 list를 넘겨줍니다
submitList로 리스트

        mainViewModel.popularGroupList.observe(viewLifecycleOwner, Observer { it ->
            it?.let { popularGroupAdapter.submitList(it) }
        })*/

    }
}