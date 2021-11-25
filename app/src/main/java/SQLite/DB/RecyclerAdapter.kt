package SQLite.DB

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var helper: SqliteHelper? = null
    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setMemo(listData[position])
    }

    inner class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        var mMemo: Memo? = null

        init {
            //삭제 버튼을 누르면 view를 지우는게 아니라 삭제 버튼이랑 매칭되는
            // Memo타입의 list 안의 데이터를 지우는 것
            //따라서 itemView나 binding.root를 전달하는게 아니라
            // position이 담긴 Memo 리스트들의 데이터를 리스트에서 삭제하고 리사이클러뷰를 다시 그려야함
           /* binding.buttonDelete.setOnClickListener {
                helper?.deleteMemo(itemView!!) //deleteMemo는 null허용 안해서 ..
                listData.remove(itemView)
                notifyDataSetChanged()
            }*/
            binding.buttonDelete.setOnClickListener {
                helper?.deleteMemo(mMemo!!) //deleteMemo는 null허용 안해서 ..
                listData.remove(mMemo)
                notifyDataSetChanged()
            }
        }

        fun setMemo(memo: Memo) {
            binding.textNo.text = "${memo.no}"
            binding.textContent.text = memo.content
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            // 날짜 포맷은 SimpleDateFormat으로 설정합니다.
            binding.textDatetime.text = "${sdf.format(memo.datetime)}"

            //position에 매칭되는 memo값을 mMemo에 임시저장
            this.mMemo = memo
        }
    }
}
