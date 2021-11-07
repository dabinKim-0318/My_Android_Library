package Room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerViewAdapter(val roomMemoList: List<RoomMemo>) : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
    class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setMemo(roomMemo: RoomMemo) {
            binding.textNo.text = "${roomMemo.no}"
            binding.textContent.text = roomMemo.content
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            // 날짜 포맷은 SimpleDateFormat으로 설정합니다.
            binding.textDatetime.text = "${sdf.format(roomMemo.dateTime)}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return roomMemoList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.Holder, position: Int) {
        holder.setMemo(roomMemoList[position])
    }

}