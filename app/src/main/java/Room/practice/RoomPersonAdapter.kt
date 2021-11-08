package Room.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.databinding.RoompersonItemlistBinding

class RoomPersonAdapter(val personList: MutableList<RoomPerson>) : RecyclerView.Adapter<RoomPersonAdapter.Holder>() {
    class Holder(val view: RoompersonItemlistBinding) : RecyclerView.ViewHolder(view.root) {
        fun setPerson(person: RoomPerson) {
            view.tvName.setText(person.name)
            view.tvPhone.setText(person.phone)
            view.tvAddress.setText(person.address)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = RoompersonItemlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setPerson(personList[position])
    }

}