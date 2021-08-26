package Kotlin

//1.사칙연산 클래스
class Carculator {
    fun pluse(vararg numbers: Int): Int {
        var result: Int = 0
        for (item in numbers) {
            result += item
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result: Int = numbers[0]
//        for (item in numbers) {
//            if(item!=numbers[0])
//            result -= item
//        }
        numbers.forEachIndexed { index, item ->
            if (index != 0)
                result -= item
        }
        return result
    }


    fun multiply(vararg numbers: Int): Int {
        var result = 1
        numbers.forEachIndexed { index, item ->
            if (item != 0)
                result *= item
        }
        return result
    }

    fun divide(vararg numbers: Int) {
        var result: Int = numbers[0]
        numbers.forEachIndexed { index, item ->
            if (index !== numbers.size - 1) {
                result = result / numbers[index + 1]
            } else {
                println(result)
            }
        }
    }
//            //if(index!==0){
//            if(value!==0){
//                result=result/value
//            }
//         }

}

class Carculator2(var initial: Int, var real: Int) {
    companion object {
        var real: Int = 7
    }

    fun plus(vararg numbers: Int): Carculator2 {
        var result = 0
        for (item in numbers) {
            result = +item
        }
        result += this.initial
        real = result
        return Carculator2(result, real)
    }

    fun minus(vararg numbers: Int): Carculator2 {
        var result = numbers[0]
        numbers.forEachIndexed { index, item ->
            if (index != 0) {
                result = result + item
            }
        }

        result = initial - result

        real = result
        return Carculator2(result, real)
    }

    fun multiply(vararg numbers: Int): Carculator2 {
        var result = 1
        numbers.forEachIndexed { index, item ->
            if (item != 0) {
                result *= item
            }
        }
        if (initial != 0) {
            result = initial * result
        }
        real = result
        return Carculator2(result, real)
    }

    fun divide(vararg numbers: Int): Carculator2 {
        var result = numbers[0]
        numbers.forEachIndexed { index, item ->
            if (index != 0) {
                result /= item
            }
        }
        if (initial != 0) {
            result = initial / result
        }
        real = result
        return Carculator2(result, real)
    }
}


//2.은행 계좌
//계좌생성기능-이름 생년월일
//        잔고확인기능,출금,예금기능
//

class MyBank(name: String, Birth: String) {
    init {
        println("안녕하세요 $name 고객님. 계좌가 정상적으로 생성되었습니다.")
        println("현재 이벤트기간이므로 1000원 공짜로 드리겠습니다^^")
    }

    var inmoney: Int = 1000
    fun inMoney(inmoney: Int) {
        if (inmoney > 0) {
            this.inmoney += inmoney
            println("입금완료: $inmoney 원 | 잔액: ${this.inmoney} 원")
        } else {
            println("마이너스 금액은 입금할 수 없습니다.")
        }
    }

    fun withDraw(outmoney: Int) {
        if (inmoney >= outmoney) {
            inmoney -= outmoney
            println("출금완료: $outmoney 원 |잔액: $inmoney 원")
        } else {
            println("잔액이 부족합니다")
        }
    }

    fun checkBalance() {
        println(inmoney)
    }
}

//        3.티비클래스
//        온 오프기능
//        채널 돌리는 기능
//        초기채널은 smk사
class TV {
    var chnnel: Int = 100 //s-1 4 M-2 5 8 K-3  6
    var current: String = "S"

    fun change() {
        if ((chnnel % 3) == 1) {
            current = "S"
        } else if ((chnnel % 3) == 2) {
            current = "M"
        } else current = "K"
    }

    fun up() {
        chnnel++
        change()
        println("현재 채널: $current 번")
    }

    fun down() {
        chnnel--
        change()
        println("현재 채널: $current 번")
    }

    fun on() {
        println("TV가 켜졌습니다.")
        println("현재 채널: $current 번")
    }

    fun off() {
        println("TV가 꺼졌습니다")
    }


}

class TV2(val chnnels: List<String>) {
    var onOrOff: Boolean = false
    var currentChannel = 0
        set(value) {
            field = value
            if (field > 2) {
                field = 0
            } else field = field
            if (field < 0) {
                field = 2
            } else field = field
        }
        get() {
            println("호출됨")
            return field //get으로 불려나간다는건 어떤 값을 반환해야하니까 return해줘야됨
        }
    //field는 원래 있던 값이고 value는 새롭게 할당하는 값임
    // 변수에 새로운 값 넣어서=value로 새로운 할당값 들어올때마다 set이 호출됨
    //set{}안에다가 currentChnnel=value 할당하면 안됨!! 무한할당->set무한호출
    //field에 value값을 넣어주면 set호출 안되고 값만 잘 들어감감
//    var currentChannel = 0
//        set(value) {  //value가 초기화하려는 할당 값이군
//         currentChannel=value
//        이렇게 하면 할당아님? 안됨 무한루프빠짐
//            currentChnnel에 1다시 1을 할당하겠다는거고 또 다시 set실행됨
//            이러면 계~속 set호출되면서 currentChnnel에 무한히 할당되기만 할뿐임
//            할당될때 set{}코드블럭이 계속 실행되니까 무한반복
//        }

    fun switch() {
        onOrOff = !onOrOff
        if (onOrOff == true) {
            println("TV 켜짐")
        } else {
            println("TV 꺼짐")
        }
    }

    fun chnnelUp() {
        currentChannel++
        println(chnnels.get(currentChannel))
    }

    fun chnnelDown() {
        currentChannel--
        println(chnnels.get(currentChannel))
    }
}


class User {
    var name: String = ""  //프로퍼티 선언시 get,set자동생성
    var address: String = "" //프로퍼티 선언시 get,set자동생성
    val phone: Int = 0 //프로퍼티 선언시 get자동생성

    constructor(name: String, address: String, phone: Int) {
        this.name = name
        this.address = address
        //this.phone=phone :val프로퍼티는 값 변경 불가
    }
}

class UserInfo {
    var name: String = ""
        set(value) {
            if (value == "김연아")
                field = "$value 는 천재입니다"
            else field=value
        }
    //get()은 따로 변경하지 않음
    var address: String = ""
        set(value) {
            if (value == "한국") {
                field = "대한민국"
            } else field = value
        }

    var phone: Int = 0

    constructor(name: String, address: String, phone: Int = 321) {
        this.name = name
        this.address = address
        this.phone = phone
    }
}

fun main(args: Array<String>) {
    val user1 = UserInfo("김연아", "한국")
    println(user1.name)
    println(user1.address)
    println(user1.phone)
    val user2 = UserInfo("홍길동", "서울")
    println(user2.name)
    println(user2.address)

}