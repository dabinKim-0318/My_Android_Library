package Kotlin

//변수 선언
class practice {
    val varable1: String = ""

    companion object {
        const val CONST = 43
    }

    val max2:Int? = if (4 > 5) {
         4
    } else if(4==5){
         4
    } else null
}

//데이터 타입,문자열 템플릿
fun practice2() {
    var double: Float = 4F
    double.toInt()

    var value2: Int = 4
    when {
        value2 == 1 -> println()
        value2 < 2 -> println() //value2가 null가지는 타입이면 안되던데 이유를 몰겟음
        value2 == null -> println()
        else -> println()  //else가 없다면? 아무 결과도 리턴X
    }
}

//함수
fun practice3(first:Int)=println()

fun main(args: Array<String>) {

    var array=IntArray(10)
    var array2=IntArray(5,{i->i+3})
    var array3=IntArray(5,{5})
    for(item in array3){print(item)}
    var array4=Array(3,{3})
    var arrayof=intArrayOf(1,2,3,4)
    arrayof.get(3)
    arrayof[5]
    var intarrayof=intArrayOf(1)


}

fun nulltest(str:String?):Int?{
    val save:Int?=str?.length ?:35
    return save
}