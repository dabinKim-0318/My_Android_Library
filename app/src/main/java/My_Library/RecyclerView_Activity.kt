package My_Library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.R
import com.example.kotlin_study.databinding.ActivityRecyclerView2Binding
import kotlinx.android.synthetic.main.activity_recycler_view2.*

class PhoneBook(val real_name: String, val real_number: String) {

}

class RecyclerView_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRecyclerView2Binding = ActivityRecyclerView2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dabinphonebook = ArrayList<PhoneBook>()
        for (item in 0..20) {
            dabinphonebook.add(PhoneBook("이름: $item ", "번호: $item+38"))
        }
        val adapter = RecyclerViewAdapter(dabinphonebook, LayoutInflater.from(this@RecyclerView_Activity))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@RecyclerView_Activity)

    }
}


class RecyclerViewAdapter(
    val itemlist: ArrayList<PhoneBook>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_name: TextView
        val item_number: TextView

        init {
            item_name = itemView.findViewById(R.id.item_name)
            item_number = itemView.findViewById(R.id.item_number)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.activity_recycler_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item_number.setText(itemlist.get(position).real_number)
        holder.item_name.setText(itemlist.get(position).real_name)
    }

}


//setContentView(R.layout.activity_recycler_view2)
//
//val dabinphonebook = ArrayList<PhoneBook>()
//for (item in 0..20) {
//    dabinphonebook.add(PhoneBook("이름: $item ", "번호: $item+38"))
//}
//val adapter = RecyclerViewAdapter(dabinphonebook, LayoutInflater.from(this@RecyclerView_Activity))
//recyclerView.adapter = adapter
//recyclerView.layoutManager = LinearLayoutManager(this@RecyclerView_Activity)
//
//}
//}
//
//
//class RecyclerViewAdapter(
//    val itemlist: ArrayList<PhoneBook>,
//    val inflater: LayoutInflater
//) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val item_name: TextView
//        val item_number: TextView
//
//        init {
//            item_name = itemView.findViewById(R.id.item_name)
//            item_number = itemView.findViewById(R.id.item_number)
//        }
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = inflater.inflate(R.layout.activity_recycler_view, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return itemlist.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.item_number.setText(itemlist.get(position).real_number)
//        holder.item_name.setText(itemlist.get(position).real_name)
//    }
//
//}