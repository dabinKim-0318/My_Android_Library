package Kotlin

fun dabin() {
    val num = sun(10, 20)

}

fun sun(first: Int, second: Int): Int {
    return first + second
}


class exclass() {
    companion object {
        const val CONST_VAL = 199
    }
}

fun main(args: Array<String>) {
    var name: String = "홍길동"
    var name2 = "홍길동"
    var name3: String
    name3 = "홍길동"

    val name4 = "김다빈"
    //name4="김수정"

    exclass.CONST_VAL

    fun str(s: String?): Int = if (null !== s) {
        s.length
    } else (0)

    val a: String? = ""
    val b = a?.toUpperCase()
    val b2 = a?.length ?: 0
    val b3 = a?.length ?: 1

    //'가' "가나" 3 a a+3
    val coffee: Boolean = true
    when (coffee) {
        true -> println()
        false -> println()
    }
    val aa=4
    val bb=33
    when(aa){
        aa+2->println()
        bb->println()
        in 4..5->println()
        !in 3..5->println()
        5,2->println()
        33->true
        else->3
    }
println(aa)

    val result=when(aa){
        1->println()
        else->println()
    }

}
