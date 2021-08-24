package Kotlin

fun main(args: Array<String>) {
    //완전 향상된 for문처럼 쓰잖아..?
    var arr = intArrayOf(1, 2, 3, 4)
    for (item in arr) {
        println(item)
    }

    var mutable = mutableListOf(1, 2, 3, 4)
    for (item in mutable) {
        println(item)
    }


    println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")

    for (item in 1..9) {
        println(item)
    }

    for ((inde, ite) in arr.withIndex()) {
        println(" $inde - $ite")
    }
    //  fun IntArray.withIndex(): Iterable<IndexedValue<Int>>

    for ((index, item) in mutable.withIndex()) {
        println(" $index - $item ")
    }

    arr.forEach { i -> println(i) }  //자바 stream foreach랑
    arr.forEach { i -> println(i + 3) }
   println(  arr.forEach { i->i })  //Unit을 반환하는데 왜 이게 되지

    println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")
//마지막 값 전까지 반복:until
    for (i in 0 until 11) {
        println(i)
    }
    println()
    for (inde in 0 until arr.size) { //arr.size하면 인덱스값을 초과해서 반복문이 돌게됨
        println(arr.get(inde))
    }
    println("구분")


//해당 수만큼 건너뛰기:step
    for (item in 0..10 step 3) {
        println(item)
    }
    println("구분12")
    for (item in 10..0) {  //오류는 안뜨는데 값이 출력이 안됨
        println(item)
    }


    //감소시키기:downTo
    for (item in 4 downTo 0) {
        println(item)  //4 3 2 1 0
    }
    println("짝수")
    //10부터 0까지 짝수만 출력
    for (item in 10 downTo 0 step 2) {  //10 8 6 4 2
        println(item)

    }
    for (item in 0 downTo 10 step 2) {  //말이 안되는구나 아예 출력안됨
        println(item)
    }

    //  for(item in 10 in 0 ){println()}  컴파일오류


    //while문은 자바랑 똑같음
    var game = 5
    while (game < 10) {
        game++
    }

    //do while
    var nowgame = 1
    val match = 6
    do {
        println(" $nowgame 이겼습니다 앞으로 ${match - nowgame} 남았습니다")
        nowgame++
    } while (nowgame < match)
    println()

    var nowgame2 = 1
    val match2 = 6
    do {
        println(" $nowgame2 이겼습니다 앞으로 ${match2 - nowgame2} 남았습니다")
        nowgame2++
    } while (nowgame2 == 6) //조건식이 true면 실행인데 이게 어떻게 true가 되니 다빈아?

    var nowgame3 = 6
    val match3 = 6
    do {
        println(" $nowgame3 이겼습니다 앞으로 ${match3 - nowgame3} 남았습니다")
        nowgame3++
    } while (nowgame3 < match3) //조건식이 true면 실행인데 이게 어떻게 true가 되니 다빈아?


    //break문
    println("구분")
    for (item in 10 downTo 0 step 2) {
        println(item)
        if (item == 4) {
            break
        }

    }
    println()
    var i = 4  //while문 변수 선언할때 조건식에서 값 계속 바뀌는거로 하려면 var로 선언~!!
    while (i > 1) {
        i--
        if (i == 3) break
    }

    //continue문
    for (item in 1..10) {
        if (item % 2 !== 0) {
            continue
        }
        println(item)
    }
    println()
    for (item in 1..10) {
        println(item)
    }

    var exam = 1
    while (exam <= 10) {
        println(exam)
        exam++
    }

}
