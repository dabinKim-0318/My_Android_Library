package com.example.kotlin_study.Android
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    println( one())
    println( max(1, 2, 3))
    println(sum())
}

fun one():String {
    var name: String = "김다빈"
    var what: String = "YB"

    return "안녕하세요 저는 안드파트 $what $name 입니다"
}

fun max(a: Int, b: Int, c: Int): Int {
    val array = arrayOf(a, b, c)
    var num = 0
    for (item in array) {
        if (item > num) {
            num = item
        }
    }
    return num
}

fun sum(): Int {
    var sum = 0
    for (item in 0..10) {
        sum += item
    }
    return sum

}
