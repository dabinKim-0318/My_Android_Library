package Kotlin

class Su(var age: Int) {
    fun increase() = age++
}

fun main() {
    Su(10).increase().let {
        print("gg")
        print("dd")
    }

}