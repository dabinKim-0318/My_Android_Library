package SQLite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.SqliteItemlistBinding
import java.text.SimpleDateFormat

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
    val listData = mutableListOf<Memo>()

    class Holder(private val view: SqliteItemlistBinding) : RecyclerView.ViewHolder(view.root) {
        fun setMemo(memo: Memo) {
            view.tvNo.setText("${memo.no}") //롱타입이라서
            view.tvContent.setText("${memo.datetime}")
            val sdf = SimpleDateFormat("yyy/MM/dd hh:mm") //=SimpleDateFormat("yyy/MM/dd hh:mm:ss")
            sdf.format(memo.datetime)
            view.tvDatetime.setText("${memo.datetime}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = SqliteItemlistBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(view)
    }

    override fun getItemCount(): Int = listData.size

    //실제 화면에 그려주는 놈 데이터 꺼내서 홀더에 있는 setMemo로 실제로 그려줌
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setMemo(listData[position])
    }
}