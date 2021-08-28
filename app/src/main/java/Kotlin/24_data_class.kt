package Kotlin

data class simple(
    val name: String,
    val age: Int
)

class Nullable {
    var nullable: String? = null
    // var notNullable:String=null
}

fun nullable(age: String?) {
    if (age != null) {
        var agelen = age.length
    }
}

fun nullReturn(): String? {
    return null
}

fun test(str: String?): Int? {
    var resultNull: Int? = str?.length ?: 0
    return resultNull
    var name: String?
    fun t() {
        name.plus("")
    }

}

fun late() {
    //var name2:String 코틀린에서는 null이 아닌 이상 초기화해주지 않으면 에러발생
    var namecheck: String = ""
    var nullName: String?=null
}

fun main(args: Array<String>) {
//    println(Sport().lateName)  변수가 초기화 되지않은 상태에서 메서드나 프로퍼티 참조하면 null예외
 //   println(Sport().lateProcess())

    val sport=Sport()
    sport.lateName="메시2"
    println(sport.lateName)
    println(sport.lateProcess())
}


class Sport{
    var name:String?=null //null로 미리 선언해둬야하는 상황 존재
    fun process(){
        name?.plus("메시")  //근데 처음에 null로 매번 초기화하면 매번 ?.로 체크해줘야됨
    }

    lateinit var lateName:String
    fun lateProcess():String?{
      return  lateName.plus("메시")
    }

}