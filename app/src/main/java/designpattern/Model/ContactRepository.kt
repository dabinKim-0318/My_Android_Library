package designpattern.Model

import android.app.Application
import androidx.lifecycle.LiveData

// ContactRepository.kt
class ContactRepository(application: Application) {

    private val contactDatabase = ContactDatabase.getInstance(application)!!  //데이터베이스 인스턴스 생성
    private val contactDao: ContactDao = contactDatabase.contactDao()  //Dao호출
    // private val contacts: LiveData<List<Contact>> = contactDao.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return contactDao.getAll()
    }

    //  Room DB를 메인 스레드에서 접근하려 하면 크래쉬가 발생

    fun insert(contact: Contact) {
        try {
            val thread = Thread(Runnable {
                contactDao.insert(contact)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }

    fun delete(contact: Contact) {
        try {
            val thread = Thread(Runnable {
                contactDao.delete(contact)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }

}