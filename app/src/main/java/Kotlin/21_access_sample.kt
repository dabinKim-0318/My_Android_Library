package Kotlin

class Dabin(private var hp: Int, private var power: Int) {

    fun attack(monster: Monster) {
        println("몬스터가 $power 의 공격을 받았다!")
        monster.depense(power)

    }

    fun depense(damage:Int) {
        hp-=damage
        println("다빈이의 남은 체력은 $hp 다!")
        if(hp<=2){
            println("heal을 가동합니다\"체력을 +1 합니다\"")
            heal()}
    }

    private fun heal() {
        if(hp>0){hp+=1
       }else{println("장렬히 안녕_게임종료")}
    }
}

class Monster(private var hp: Int, private val power: Int) {
    fun attack(dabin: Dabin) {
        println("다빈이가 $power 의 공격을 받았다!")
        dabin.depense(power)

    }
    fun depense(damage:Int) {
        hp-=damage
        if(hp==0){println("몬스터 사망_게임종료")}
        else println("몬스터의 남은 체력은 $hp 다!")
    }
}

fun main(args:Array<String>){
    var dabin=Dabin(10,3)
    var monster=Monster(6,2)

    monster.attack(dabin)
    monster.attack(dabin)
    monster.attack(dabin)
    monster.attack(dabin)
    dabin.attack(monster)
    dabin.attack(monster)

}

