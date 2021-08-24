package Kotlin

//12.배열
//같은 타입 데이터만 저장X/길이변경 불가

fun main(args: Array<String>) {

//    공간 할당
//    // int[] arr2=new int[3]  자바
    var arr = IntArray(10)

    var arr2 = IntArray(10, { i -> i + 3 }) //공간할당+인자 넣기
    var arr6 = Array(4,{i->""})
//    값 할당
//    // int[] arr={1,2,3,4}  자바
//    var arr2 = arrayOf<Int>(1, 2, 3, 4)  //Int타입만 가능
    var arr3 = arrayOf(1, 2, "응아니", '신') //지네릭스 생략 시 모든 타입
    var arr45 = intArrayOf(1, 2, 3, 4)
//    println(arr2 is Array)


//배열 꺼내는 방법(1)
    val arrvalue2 = arr3.get(3)
    val arrvalue = arr[2]
//배열 값 바꾸는 방법
    val arrvalue3 = arr.set(0, 24)
    arr[0] = 3
    println(arr3)

}