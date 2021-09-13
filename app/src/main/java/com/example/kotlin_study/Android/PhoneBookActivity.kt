package com.example.kotlin_study.Android

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
class PhoneBook() {
    val personList = ArrayList<Person>()
    fun addPerson(person: Person) {
        personList.add(person)
    }
}
class Person(val name: String, val number: String) {}


class PhoneBookActivity : AppCompatActivity() {
    //Activity가 시작되고 onCreate의 범위가 어디까지인가 잘 생각!!!=무엇을 호출시킬 것인가?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)
  }

    fun createFakePhoneBook(faskNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until faskNumber) {
            phoneBook.addPerson(Person("$i 번째 사람", "$i 번째 사람의 전화번호"))
        }

        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook) {
        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)

        for (i in 0 until phoneBook.personList.size) {
            val view = layoutInflater.inflate(R.layout.phonebook_item, null, false)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(phoneBook.personList.get(i).name)

            //addSetOnClickListener을 직접 정의해서 각 객체가 리스트로 만들어질때 setOnClickListener호출 대기 상태가 되도록
            addSetOnClickListener(phoneBook.personList.get(i), view)
            container.addView(view)
        }
    }

    fun addSetOnClickListener(person: Person, view: View) {
        //각 객체의 setOnClickListener가 호출될때 intent로 정보 전달하면서 상세 Activity 실행
        view.setOnClickListener {
            val intent = Intent(this@PhoneBookActivity, PhoneBook_detail_Activity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }

}

