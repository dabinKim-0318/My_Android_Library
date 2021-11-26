package Lambda

fun main() {
    //1. 고차함수
    val res1 = sum(3, 2)
    val res2 = mul(sum(3, 2), 5)

    //2. 일반 변수에 람다식 할당
    //변수이지만 람다식을 리턴받는 변수이기 때문에 함수처럼 사용할 수 있음
    val multi: (Int, Int) -> Int = { a: Int, b: Int -> a * b }

    //3. 람다식이 할당된 변수는 함수처럼 사용 가능
    val result: Int
    result = multi(10, 20)

    //4. 자료형의 생략
    val test1: (Int, Int) -> Int = { a: Int, b: Int -> a * b }
    val test2 = { a: Int, b: Int -> a * b }
    val test3: (Int, Int) -> Int = { a, b -> a * b }

    //5. 반환자료형이 없거나 매개변수가 하나
    val test4: () -> Unit = { println("Hello") }
    val test5: (Int) -> Int = { a -> a * a }
    // val test5: Int -> Int = { a -> a * a }  ()생략이 안됨
    println(test4) //Function0<kotlin.Unit>
    println(test4())  //Hello

    // 6.선언부의 자료형 생략
    val test6 = { println("Hello") }
    //   val test7 = { a, b -> a * b } 선언자료형 생략시 매개변수 자료형 생략 불가
    val test7 = { a: Int, b: Int -> a * b }

    //7. 항상 마지막 부분이 반환값임
    val test8 = { a: Int, b: Int ->
        println("첫번째줄")
        println("두번째줄")
        println("세번째줄")
    }

    //8. 인자에 람다사용하는 고차함수
    fun test9(minus: (Int, Int) -> Int, b: Int, c: Int): Int {
        return minus(b, c)
    }

    test9({ a: Int, b: Int -> a - b }, 20, 10)  //함수의 인자로 람다식 사용

    //9. 람다 호출 ->()로 호출
    val test10 = callByValue(Lambda())
    println(test10)

    //10. 람다 호출 ->람다 이름으로 호출
    val test11 = callByValue2(otherLambda)
    println(test11)

    //11. 일반함수인걸 람다식처럼 매개변수 인자로 사용하고 싶을때
    // order(sum11,11,12)
    order(::sum11, 11, 12)

    //12. 매개변수가 없는 경우 () 생략
    noParam({ "Hi" })
    noParam() { "Hi" } //람다식이 하나 있는 경우 () 밖으로 {} 빼내오기 가능
    noParam { "Hi" } // () 밖으로 {} 빼내오고 () 생략 가능

    //13. 매개변수가 하나인 경우
    oneParam({ a -> a })
    oneParam() { a -> a }
    oneParam { a -> a }
    oneParam { "a+$it" } //it이 파라미터의 인자로 들어온 값 역할

    //14. 매개변수 두개
    moreParam { a, g -> a + g }  //인자를 it으로 대체할 수 없음!

    //15. 마지막 인자가 람다인 경우 밖으로 빼낼 수 있음
    withArgs("a", "b", { a, b -> a + b })
    withArgs("a", "b") { a, b -> a + b }

    //16. 인자 람다 많은 경우
    withArgs2("a", { a, b -> a + b }, { a, b -> a + b })
    withArgs2("a", { a, b -> a + b }) { a, b -> a + b }


}
fun withArgs3(a: String, out1: (String, String) -> String, out: (String, String) -> String) {
    println("out(a, b)")
}


fun withArgs2(a: String, out1: (String, String) -> String, out: (String, String) -> String) {
    println("out(a, b)")
}

fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}

fun noParam(out: () -> String) {
    println(out())
}

fun moreParam(out: (String, String) -> String) {
    println(out("", ""))
}

fun oneParam(out: (String) -> String) {
    println(out(""))
}

fun order(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}

fun sum11(a: Int, b: Int): Int {
    return a + b
}

fun callByValue2(b: () -> Boolean): Boolean {
    println("callByValue2")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda")
    true
}


fun callByValue(b: Boolean): Boolean {
    println("callByValue")
    return b
}

val Lambda: () -> Boolean = {
    println("Lambda") //출력됨!! return이 안될뿐
    true
}

fun sum(a: Int, b: Int) = a + b
fun mul(a: Int, b: Int) = a * b
fun funFunc(): Int {
    return sum(2, 2) //함수의 반환값으로 함수 사용
}

