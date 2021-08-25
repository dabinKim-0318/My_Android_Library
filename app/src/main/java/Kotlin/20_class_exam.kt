package Kotlin

import java.util.*

//1.사칙연산 클래스
class Carculator {
    var num1: Int = 0;
    var num2: Int = 0;

//    constructor(num1: Int, num2: Int) {
//        this.num1 = num1
//        this.num2 = num2
//    }

    fun plus(): Int = num1 + num2
    fun mius(): Int = num1 - num2
    fun mutiply(): Int = num1 * num2
    fun divide(vararg numbers:Int){
        var result:Int=numbers[0]
        numbers.forEachIndexed{index,item->
            if(index!==numbers.size-1){
           result= result/numbers[index+1]}else {println(result)}
//            //if(index!==0){
//            if(value!==0){
//                result=result/value
//            }
//         }
        }
    }



}
fun main(args: Array<String>) {
Carculator().divide(16,4,2)
//    println(Carculator(1, 2).plus())
//    var dabin = MyBank("김다빈", "980318")
//    dabin.inMoney(5000)
//    dabin.withDraw(3000)
//    dabin.withDraw(2000)
}
//2.은행 계좌
//계좌생성기능-이름 생년월일
//        잔고확인기능,출금,예금기능
//

class MyBank(name: String, Birth: String) {
    init {
        println("안녕하세요 $name 고객님. 계좌가 정상적으로 생성되었습니다.")
    }

    var inmoney: Int = 0
    fun inMoney(inmoney: Int) {
        this.inmoney += inmoney
        println("입금완료: $inmoney 원 | 잔액: ${this.inmoney} 원")
    }

    fun withDraw(outmoney: Int) {
        if (inmoney >= outmoney) {
            inmoney -= outmoney
            println("출금완료: $outmoney 원 |잔액: $inmoney 원")
        } else {
            println("잔액이 부족합니다")
        }
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
        }else if((chnnel % 3) == 2) {
            current = "M"
        }else current="K"
    }
    fun up(){
        chnnel++
        change()
        println("현재 채널: $current 번")
    }

    fun down(){
        chnnel--
        change()
        println("현재 채널: $current 번")
    }
    fun on(){
        println("TV가 켜졌습니다.")
        println("현재 채널: $current 번")
    }

    fun off(){
        println("TV가 꺼졌습니다")
    }


}

