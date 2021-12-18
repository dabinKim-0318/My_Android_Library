package designpattern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_study.R
import designpattern.Model.Contact

// ContactAdapter.kt

class ContactAdapter(val contactItemClick: (Contact) -> Unit, val contactItemLongClick: (Contact) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private var contacts: List<Contact> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(contacts[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTv = itemView.findViewById<TextView>(R.id.item_tv_name)
        private val numberTv = itemView.findViewById<TextView>(R.id.item_tv_number)
        private val initialTv = itemView.findViewById<TextView>(R.id.item_tv_initial)

        fun bind(contact: Contact) {
            nameTv.text = contact.name
            numberTv.text = contact.number
            initialTv.text = contact.initial.toString()

            itemView.setOnClickListener {
                contactItemClick(contact)
            }

            itemView.setOnLongClickListener {
                contactItemLongClick(contact)
                true
            }
        }
    }

    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

}
