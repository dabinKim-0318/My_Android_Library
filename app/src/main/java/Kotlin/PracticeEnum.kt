package Kotlin

enum class PracticeEnum {
}

data class People(
    val name: String,
    val age: Int
)

fun main() {
    println(People("다빈", 20)) //People(name=다빈, age=20)
    val peopleA = People("H43RO", 23)
    val peopleB = People("H43RO", 23)

    //프로퍼티가 같은 인스턴스를 만들어서 hashCode()를 출력하면 같은 hashCode로 나옴
    println(peopleA.hashCode())
    println(peopleB.hashCode())

    //equals도 오버라이딩하고 있어서 프로퍼티 같으면 true나옴
    println(peopleA == peopleB)
}