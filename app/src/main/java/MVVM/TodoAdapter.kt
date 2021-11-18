package MVVM

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.ItemTodoBinding

class TodoAdapter(val todoItemClick: (Todo) -> Unit, val todoItemLongClick: (Todo) -> Unit):
    RecyclerView.Adapter<TodoAdapter.ViewHolder> () {
    private var todos: List<Todo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    inner class ViewHolder(val binding: ItemTodoBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(todo: Todo) {
            binding.todo = todo

            binding.root.setOnClickListener {
                todoItemClick(todo)
            }
            binding.root.setOnLongClickListener {
                todoItemLongClick(todo)
                true
            }
        }
    }
    fun setTodos(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()

    }


}