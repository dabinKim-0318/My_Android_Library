package Recyclerview.base

import Recyclerview.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.ItemFollowerListBinding


class DiffUtilRecyclerView : RecyclerView.Adapter<DiffUtilRecyclerView.ViewHolder>() {
    val followerList = mutableListOf<Data>()

    inner class ViewHolder(private val view: ItemFollowerListBinding) : RecyclerView.ViewHolder(view.root) {
        fun onBind(data: Data) {
            view.textView5.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = followerList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

}

