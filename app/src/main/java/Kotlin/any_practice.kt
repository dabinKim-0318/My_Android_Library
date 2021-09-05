package Kotlin


class Test {
    fun test(ob1: Any?, ob2: Any?) {
        if (ob1 is String && ob2 is String) {
            val v1 = ob1.toString()
            val v2 = ob2
        }
    }
}

open class AnyClass(any: Any) {

}


open class Person10 {
    open fun funtest(): String {
        return "hi"
    }
}

interface Body {

    fun arm()
}

class asTest: Person10(){

}

fun main() {

val person:Person10=asTest()
    person as asTest

    var double3: Double = 4.3


    val any2: AnyClass = object : AnyClass(Person10()) {}


    val name: Any = object : Any() {
        val yourname = "길동"
        override fun toString(): String {
            return "내이름은 길동이다"
        }
    }

    val test = object : Person10() {
        val age = 20
        override fun funtest(): String {
            return "bye"
        }
    }

    val test1 = object : Body {
        override fun arm() {
        }
    }

    val string: String = "1"
    val int: Int = string.toInt()

    val int2: Int = 10
    val double: Double = int2.toDouble()

    val a:Int?=null
    val b:Int=3
    val c:Int?=a?.plus(b) ?:10 //Int클래스의 메서드 plus,minus,times,div

    val number1:Int?=null
    val number2:Int=5
    val sum=number1?.plus(number2) ?:10
   // val sum=number1+number2 ?:10

    val aa=3
    val gg=3
    val gd=aa+gg


    val sport=Sport2()
    sport.lateName="메시2"
    println(sport.lateName)
    println(sport.lateProcess())
}

class Sport2{

    lateinit var lateName:String
    fun lateProcess(){
        lateName.plus("메시")
    }
}