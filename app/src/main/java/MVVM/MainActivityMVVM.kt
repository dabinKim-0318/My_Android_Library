package MVVM

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityMainMvvmBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityMVVM : AppCompatActivity() {
    private lateinit var binding: ActivityMainMvvmBinding
    val ViewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainMvvmBinding>(this, R.layout.activity_main_mvvm)
        binding.lifecycleOwner = this
        binding.viewModel = ViewModel
        setRecyclerView()

        binding.mainButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    private fun deleteDialog(todo: Todo) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected contact?")
            .setNegativeButton("취소") { _, _ -> }
            .setPositiveButton("편집") { _, _ ->
                val intent = Intent(this, AddActivity::class.java)
                intent.putExtra(AddActivity.EXTRA_TODO_TITLE, todo.title)
                intent.putExtra(AddActivity.EXTRA_TODO_DESC, todo.description)
                intent.putExtra(AddActivity.EXTRA_TODO_ID, todo.id)
                startActivity(intent)
            }.setNeutralButton("삭제") { _, _ ->
                lifecycleScope.launch(Dispatchers.IO) { ViewModel.delete(todo) }
            }
        builder.show()
    }

    private fun setRecyclerView() {
        // Set contactItemClick & contactItemLongClick lambda
        val adapter = TodoAdapter({ todo -> deleteDialog(todo) }, { todo -> deleteDialog(todo) })

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        ViewModel.getAll().observe(this, Observer { todos ->
            adapter.setTodos(todos!!)
        })
    }
}