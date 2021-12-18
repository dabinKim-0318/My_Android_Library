package designpattern.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import designpattern.Model.Contact
import designpattern.Model.ContactRepository

// ContactViewModel.kt

class ContactViewModel(application: Application) : AndroidViewModel(application) {

/*    AndroidViewModel 에서는 Application을 파라미터로 사용한다.
    (Repository를 통해서) Room 데이터베이스의 인스턴스를 만들 때에는 context가 필요하다.
    하지만, 만약 ViewModel이 액티비티의 context를 쓰게 되면, 액티비티가 destroy 된 경우에는 메모리 릭이 발생할 수 있다.
    따라서 Application Context를 사용하기 위해 Applicaion을 인자로 받는다.*/

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }
}
