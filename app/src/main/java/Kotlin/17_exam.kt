package Kotlin

//list를 두개 만든다
//        첫번째 arraylist에는 0부터 9까지의 값을 넣는다-반복문 사용
//        두번째 arrayList에는 첫번쨰 arrayList의 값을 하나씩 확인한 후
//        짝수면 트루, 홀수면 false를 넣는다
//
//        2.학점
//        80-90 a 70-79 b 60-69 c 나머지 f학점
//
//        3.전달받은 숫자의 각 자리 수의 합 구함
//        전달 받은 숫자는 무조건 두자리 수
//
//        4구구단

//1.
fun main(args: Array<String>) {
    var mutable1 = mutableListOf<Int>()
    for (item in 0..9) {
        mutable1.add(item)
    }
    var mutable2 = mutableListOf<Boolean>()
    for (item in 0..mutable1.size - 1) {
        if (mutable1.get(item) % 2 == 0) {
            mutable2.add(true)
        } else {
            mutable2.add(false)
        }
    }
  println(mutable2)

    //인강 답
    val list1=MutableList(9,{0})
    val list2=MutableList(9,{true})
    for(i in 0..8){
        list1[i]=i+1
    }

    list1.forEachIndexed{index,item->
        if(item%2!==0){
            list2[index]=false
        }else{}
    }
  println(list2)


    //2. 학점
    fun second(score:Int):String{
    when (score) {  //조건을 만족하는 return을 만나면 바로 나가고 when문도 조건을 만족하면 빠져나감 위에서부터 아래로.
        in 80..90 -> return "A"
        in 70..79 -> return "B"
        in 60..69 -> return "C"
        else -> return "F"
    }
    }

    //        3.전달받은 숫자의 각 자리 수의 합 구함
    fun inputPlus(input: Int) {
        var ten = input / 10
        var one = input % 10
        println(ten + one)
    }

    inputPlus(66)

    for(item in 1..9){
        for(item2 in 1..9){
            print("$item X $item2 = ${item*item2} | ")
        }
        println()
    }
}