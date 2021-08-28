package Kotlin


fun main(args: Array<String>) {
var supernight=SuperNight(130,5)
var supermonster=SuperMonster(100,2)
    supernight.attack(supermonster)

}

open class Charator(var hp: Int, val power: Int) {
    fun attack(charator: Charator, power: Int = this.power) {
        charator.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        //호출된 클래스 이름을 알 수 있음 이때 defense호출한 클래스는 SuperNight임
        if (hp > 0) println(" ${javaClass.simpleName} 의 남은 체력은 $hp 입니다")
        else println("사망했습니다")
    }
}

//open class Charator(var hp:Int, var power:Int){
//  fun attack(charator: Charator,power:Int=this.power){}  가능
//fun attack(charator:Charator,power:Int=power) 불가능
//fun attack(charator:Charator,power)  변수가 선언되어야 함. 값이 바로 전달될 수 없어
//fun attack(Charator:Charator,power:Int)  이건 지역변수되고


//부모생성자에 전달되는 파라미터는 이미 부모생성자에서 var val로 선언해두었기때문에
//자식생성자에서 var val을 붙이면 안됨
class SuperMonster(hp: Int, power: Int) : Charator(hp, power) {
    fun bite(charator: Charator) {
        super.attack(charator, power + 2)
    }
}

//부모생성자에 전달되는 파라미터는 이미 부모생성자에서 var val로 선언해두었기때문에
//자식생성자에서 var val을 붙이면 안됨
class SuperNight(hp: Int, power: Int) : Charator(hp, power) {
    override fun defense(damage: Int) {
        super.defense(damage - 2)
    }

}


