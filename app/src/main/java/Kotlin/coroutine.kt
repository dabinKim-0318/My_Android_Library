package Kotlin


import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//실행과 동시에 바로 종료 되기 때문에 코루틴이 실행되지 못한것(기다리지 못한 것)
    //따라서 코루틴이 끝까지 실행되는 것을 보장하기 위해서는 일정한 범위내에서 기다려주어야 한다.
    //GlobalScope.launch

    runBlocking {
        var a = launch {
            for (i in 1..5) {
                println(i)
                delay(10)  //milisecond 단위로 루틴을 잠시 대기시키는 함수
            }
        }

        //반환값이 있는 Deffered 객체(마지막 값 Return)
        val b = async {
            "async 종료"
        }


        println("async 대기")
        println(b.await())
        //async=Deferred의 실행이 끝날때까지 대기하는 함수
        //  Deferred의 결과도 반환

        println("launch 대기")
        a.join()  //launch=Job의 실행이 끝날때까지 대기하는 함수
        println("launch 종료")
    }
}