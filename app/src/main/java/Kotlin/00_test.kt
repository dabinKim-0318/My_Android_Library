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

private class mother {
    //클래스의 접근 제한자에  private이 붙네.. class는 접근 제한자 안붙어있으면 원래 private이 기본.
    // 기본=private class=자식 클래스 생성 불가=생성자 private아니니까 객체 생성은 가능
    fun dabin() {}
}

open class mother1 {
    private constructor()
    constructor(hi: String)
}

//class child:mother{} private class는 자식 클래서 생성 불가
//class child1:mother1(){}  생성자가 private이라 부모 클래스 생성자 호출해서 자식 클래스 생성 불가
class child2(hi: String) : mother1(hi) {} //보무 생성자 중 private아닌 생성자 호출해서 클래스 생성 가능


fun main(args: Array<String>) {

    mother().dabin()  //private class 역시도 생성자 호출해서 객체 생성이 가능! 메서드 필드 호출도 됨
    //mother1()  외부에서 객체 생성을 불가능하게 하려면 생성자가 private이여야함
    //mother().num


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
    val aa = 4
    val bb = 33
    when (aa) {
        aa + 2 -> println()
        bb -> println()
        in 4..5 -> println()
        !in 3..5 -> println()
        5, 2 -> println()
        33 -> true
        else -> 3
    }
    println(aa)

    val result = when (aa) {
        1 -> println()
        else -> println()
    }

    val apple = if (3 > 5) true else false
    val apple3 = when (apple) {
        true -> 1
        false -> 3
    }
    println("ㄷㄷㄷ")
    val arr = Array(4, { i -> i + 2 })
    for (item in arr) {
        println(item)
    }

    val arr2 = intArrayOf(1, 2, 3, 4)
    val arr3 = arrayOf(3, 'f', 2, 5)
    //  val arr4=StringArrayOf("김","ㄱ")
    val arr5 = arrayOf<String>("d")
    arr2.get(4)

    val mutable = mutableListOf<Int>()
    mutable.add(1)


}
