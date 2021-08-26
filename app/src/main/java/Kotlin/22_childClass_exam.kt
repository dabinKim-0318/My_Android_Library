package Kotlin

//기사,몬스터의 자식인 supernight,supermonster을 만들고 얘네만 가진 기능을 만들어라

open class Night2(var ph: Int, var power: Int) {
    open fun attack(monster: Monster2) {
        monster.depense(power)
    }

    open fun depense(damage: Int) {
        ph -= damage
        if (ph < 3) {
            heal()
        }
    }

    fun heal() {
        if (ph != 0)
            this.ph++
    }
}

open class Monster2(var ph: Int, var power: Int) {
    open fun attack(night: Night2) {
        night.depense(power)
    }

    open fun depense(damage: Int) {
        ph -= damage
    }
}

class Night3(var name: String, var ph2: Int, var power2: Int) : Night2(ph2, power2) {
    override fun attack(monster: Monster2) {
        monster.depense(power)
        jap()
    }

    override fun depense(damage: Int) {
        ph -= damage
        if (ph < 3) {
            heal()
        }
    }

    fun jap() {
        println("몬스터 쨉!")
    }
}

fun main(args: Array<String>) {
    val dabin = Night3("김다빈", 10, 4)
    dabin.attack(Monster2(3, 2))
    Monster2(29, 24).attack(dabin)
}