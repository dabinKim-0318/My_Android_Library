package RunCatching

class RunCatchingPractice {
    val k: String = "hi"
    fun tryCatch() {
        try {
            if (k == "hi") println("k는 hi이다")
            else println("k는 hi가 아니다")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            println("finally")
        }
    }

    fun runCatching() {
        runCatching {
            k == "hi"
        }.onSuccess {
            if (true) println("k는 hi이다")
            else println("k는 hi가 아니다")
        }.onFailure {
            it.printStackTrace()
        }.also {
            println("finally")
        }
    }

    fun MapCatching() {
        val k2: String? = null
        runCatching {
            k2 == "hi"  //runCatching구문 안의 코드가 성공하냐 안하냐가 onSuccess인지 onFilure인지를 가르는거임 여기서 Boolean이 false라는거 도출 성공!
        }.mapCatching { //성공했으니까 여기서 k is null로 매핑
            //성공 시 매핑
            println("k is $k2")
        }.recoverCatching {  //실패하지 않았으니까 해당 구문 뛰어넘음.실행안됨!
            //실패시 적용
            when (it) {
                null -> "still good"
                else -> println("여기")
            }
        }.onSuccess {  //성공한 결과로 mapCatching으로 매핑했던 결과 나옴
            println("$k2+$k2")
        }.onFailure {
            it.printStackTrace()
        }.getOrDefault("default")  //리턴값이 필요한 경우 사용
    }
}

fun main() {
    /*  RunCatchingPractice().tryCatch()
      RunCatchingPractice().runCatching()*/
    RunCatchingPractice().MapCatching()
}