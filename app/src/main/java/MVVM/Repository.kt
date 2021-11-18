package MVVM

import android.app.Application
import androidx.lifecycle.LiveData

class Repository(application: Application) {
    private val todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)!!
    private val todoDao: TodoDao = todoDatabase.todoDao()
    private val todos: LiveData<List<Todo>> = todoDao.getAll()

    fun getAll(): LiveData<List<Todo>> {
        return todos
    }

    fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    fun delete(todo: Todo) {
        todoDao.delete(todo)
    }
}

/*
class Repository(application: Application) {
    //빌드한 helper가져오기
    private val contactDatabase = ContactDatabase.getInstance(application)!!

    //helper에 Dao연결
    private val contactDao: ContactDao = contactDatabase.contactDao()

    //contactDao로 데베 리스트 전부 가져오기
    private val contacts: LiveData<List<Contact>> = contactDao.getAll()

    //getAll호출하면 리스트 전부 가져오도록 함수로 싸버렸군
    fun getAll(): LiveData<List<Contact>> {
        return contacts
    }

    //insert호출시 리스트에 객체 하나 넣는거 백그라운드 스레드에서 실행하도록
    fun insert(contact: Contact) {
        try {
            val thread = Thread(Runnable { contactDao.insert(contact) })
            thread.start()
        } catch (e: Exception) {
        }
    }

    fun delete(contact: Contact) {
        try {
            val thread = Thread {
                Runnable {
                    contactDao.delete(contact)
                }
            }
        } catch (e: java.lang.Exception) {
        }
    }
}*/
