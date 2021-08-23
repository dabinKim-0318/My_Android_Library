package Kotlin

fun main(args: Array<String>) {



    val value22:Int=10
    val value: Int = 3
    when (value) {  //파라미터 값:기본타입,문자열 리터럴,변수,연산식
        1 -> println()  //조건식:기본타입,문자열 리터럴,변수,연산식
        2/1 -> println()
        value22->println()
        3,5 -> println("ee")  //콤마로 구분해서 사용
        in 5..7 -> println() //범위 값 비교
        !in 8..9 -> println()
        null -> println()
        else -> println()
        //모든 case가 아닐때, java의 default와 같은 역할
        //생략가능하지만 when구문에 대응할 수 있는 모든 경우의 수를 쓰는게 좋음
    }


    //파라미터 없이 사용
    val value2: Int = 4
    when {
        value2 == 1 -> println()
        value2 > 2 -> println()
        value == null -> println()
        else -> println()
    }


//null타입 파라미터
    val value3: Int? = null
    when (value3) {
        null -> println()
        else -> println()
    }

    val value5: Boolean? = null
    when (value5) {
        true -> println()
        false -> println()
        //null->println()   조건으로 갖는 값의 모든 경우 대응 할 것, 생략해도 오류는 아닌데 대응하는 게 좋음
    }

    val value52: Boolean = true
    when (value52) {
        true -> println()
        false -> println()
        //조건으로 갖는 값의 모든 경우 대응 할 것 null가질 수 없으므로 return할 수 있는 경우의수 true/false밖에 없음
    }

    //값을 리턴하는 when구문의 경우 반드시 값을 리턴해야함
    val value6: Boolean? = null
    val returnval:Int = when (value6) {
        true -> 1
        false -> 2
        else -> 3   //else없으면 오류, null을 가질 수 있는 Boolean타입이므로 모든 경우의 수 작성
     //   null -> 4 else대신 null인 경우로 해도됨
    }

    //true, false를 리턴하는 when
    val value9:Int=10
    when(value9){
        is Int->println("value9 is Int")
        else->println("value9 is not Int")
    }

    val day:String="월"
    when(day){
        "월"->println()
    }

    var value10=22
    var result=when(10/3){
        value10->true
        in 5..20->false
        5/2->false
        else->true
    }
    println(result)

}

//when의 조건식에는 true나 false를 리턴하는 어떤것이든 사용할 수 있다