package Recyclerview.ListAdapter


import Recyclerview.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.ItemFollowerListBinding


/*AsyncListDiffer는 아이템 리스트를 교체하는 replaceTo(),
특정 포지션의 아이템을 반환하는 getItem() 등
RecyclerView.Adapter 인터페이스에 맞춰 개발자가 손수 구현해야하는 기능들이 있다.
이것마저 할 필요가 없게 해주는게 바로 ListAdapter다.
ListAdapter는 AsyncListDiffer의 wrapper 클래스로, RecyclerView.Adapter<VH>를 구현하고 있음*/

/*ListAdapter<데이터 클래스, 리사이클러뷰 뷰홀더>(개발자 정의 콜백)
ListAdapter는 데이터 클래스를 받고 있다는 게 특징인데요,
이는 사용자가 어댑터 내에서 데이터 리스트를 정의하지 않고 리스트 자체에서 데이터 리스트를 정의하기 때문입니다.
그래서 ListAdapter에서 구현해야 할 함수를 보면 getItemCount가 사라져 있는 것을 알 수 있습니다.*/
//Data
class ListAdapterRecyclerView : ListAdapter<Data, ListAdapterRecyclerView.ViewHolder>(PlaceDiffUtilCallback()) {
    val followerList = mutableListOf<Data>()

    inner class ViewHolder(private val view: ItemFollowerListBinding) : RecyclerView.ViewHolder(view.root) {
        fun onBind(data: Data) {
            view.textView5.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterRecyclerView.ViewHolder {
        val view = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         // holder.onBind(followerList[position])
        //    getItem(position: Int) : protected method라 클래스 내부에서 구현할 때 사용합니다. 어댑터 내 List Indexing을 할 때 활용됩니다
        holder.onBind(getItem(position))

    }

}

