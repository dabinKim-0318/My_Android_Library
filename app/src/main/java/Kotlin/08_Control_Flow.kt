package Kotlin

fun main(args: Array<String>) {
    val a = 0
    val b = 3

    if (a > b) {
        println("크다")
    } else if (a == b) {
        println("같다")
    } else {
        println("작다")
    }
//값을 리턴하는 if사용법
    val max = if (a > b) a else b
    val max2 = if (a > b) {
        val c = 4
        a
    } else {
        b
    }

    val max3 = if (a > b) {
        a
    } else if (a == b) {
        println("둘이 같음")
    } else {
        b     //값 리턴하는 if문 사용할때는 반드시!!! 리턴하는 경우의 수 다 작성 *Boolean타입의 경우의 수랑 헷갈리지 말것
    }
//엘비스 연산자
    val number: Int? = null
    val number1: Int? = 100
    val number2 = number1 ?: 10
    val number3 = number ?: 10
    println(number2) //number1이 null이 아니므로 100
    println(number3) //number이 null이므로 10


    fun result(s:String?)=s?.length ?:0


val dabin:String?="김다빈"

val age=23
    val myage="제 나이는 ${age+3} 입니다"




}