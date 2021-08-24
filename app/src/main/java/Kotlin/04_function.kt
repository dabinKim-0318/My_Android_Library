package Kotlin
//04_function
//fun 함수명(변수:변수타입, 변수:변수타입): 반환타입{
// 함수 내용
// return 반환값
// }

// -디폴트 값X, 반환값O
fun plus(first: Int, second: Int): Int {
    println("홍길동")
    val result: Int = first + second
    return result
}

// -디폴트 값O, 반환값O
//인수: 함수에 매개변수가 있을 때 해당 함수를 호출할 때 매개변수에 넘겨주는 값을 인수
//기본인수:함수를 호출하는 호출자가 피호출자의 매개변수에 넘겨줄 값이 없을 경우에 기본값으로 적용해주는 것을 기본 인수
fun plusFive(first: Int, second: Int = 5): Int {
    val result = first + second
    return result
}

// -디폴트 값X, 반환값X: Unit생략 가능
fun printPlus(first: Int, second: Int): Unit {
    return Unit
}
fun print2(first:Int,second:Int):Unit{}


// -간단하게 메서드 선언
fun plusShort(first: Int, second: Int) {
    val result = first + second
}

fun plusShot2(first: Int, second: Int): Int = first + second //first+second타입 추론 가능하기에 리턴타입인 Int도 생략 가능


//-가변인자를 갖는 함수 선언
fun plusMany(vararg numbers:Int){
    for (number in numbers){
        println(number)
    }
}

//-내부함수
fun showMyPlus(first:Int, second:Int):Int{
    println(first)
    println(second)
    fun plus(first:Int, second:Int):Int{
        return first+second
    }
    return plus(first,second)  //ctrl누르고 가져다대면 first가 누구의 매개변수인지 알수잇음
}


fun main(array: Array<String>) {
    println(plus(2, 3))  //5
    println(plusFive(1))  //6
    println(plusFive(2, 10))  //12
    println(plusMany(1,2,3,4,5))

    println(printPlus(3,5).hashCode())
    println(print2(3,5).hashCode())
}



