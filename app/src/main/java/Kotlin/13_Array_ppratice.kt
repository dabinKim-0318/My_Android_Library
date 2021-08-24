package Kotlin

import android.os.Build
import androidx.annotation.RequiresApi

//컬렉션 값의 단위=엘리먼트
//컬렉션에 입력되는 값은 각각을 엘리먼트라고함

var arr4 = IntArray(10, { 0 })  //0으로 초기화
var arr5 = Array(4, { 1;2;3;4 }) //;으로 해야됨

class food {

}

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
//빈 리스트 생성
    var list2 = mutableListOf<String>() //빈 리스트 생성시에는 지네릭 생략 불가


    //제한없는 지네릭스 T타입이라 모든 자료형 인자 값으로 받는 군
    val list = mutableListOf("1", 2, 3 , 4)
    println(list.add(5)) //배열 마지막에 5 추가: true리턴
    list.add(0, 100) //0번째 인덱스에 100추가
    list.set(1, 200) //1번 인덱스 값 200으로 바꿈
    println(list.contains(200)) //200 포함? :true 리턴
    println(list.isEmpty()) //빈 배열임?: false
    println(list.size)  //*자바랑 다르다!!!!!!!!!!!자바는 size()로 배열 값 개수 가져왔는데 얘는 필드인가
    println(list.get(0)) //0번째 인덱스 값 줌: 100
    println(list.indexOf(100)) //100의 인덱스 번호 리턴: 0
    //list.clear()  값 싹다 지우는거 가능
    list.remove(100) //해당 객체 지우기
    list.remove(387647)  //없는 값을 삭제하려해도 오류 발생 안함
    list.removeAt(0)   //*해당 인덱스 객체 삭제  자바 컬렉션은 remove인자로 인덱스,객체 둘다 받았는데 다르네!
    println(list) //자바랑 마찬가지로 배열은 참조 번지 출력되는데 얘는 배열 값들 출력되는군
    for (item in list) {
        println(item)
    }


    //set
    var set = mutableSetOf(1, 2, 3, 4, 4)
    println(set) //4출력 안되고
    println(set.add(500)) //500추가:true리턴
    set.contains(500) //500값으로 잇음?:true리턴
    set.isEmpty() //set컬렉션 비어있음?:false
    set.size  //값 수
    //set.clear()
    println(set.remove(500))//500 삭제:true리턴
    set.remove(56872634) //없는 값 삭제하려해도 오류 발생 안함
    for (item in set) {
        println(item)
    } //향상된 for문으로 꺼내오기

    var set2 = mutableSetOf<Int>()

    //List,Set의 집합 메서드도 전부 사용가능
    set.addAll(set2)
    set.removeAll(set2)

    //Map 키 중복 불가 값 중복 허용
    var map = mutableMapOf<String, String>()
    map.put("1", "김숙")
    map.put("2", "전지현")
    map.put("1", "김씨네")  //값 수정!! set메서드랑 비슷하군
    println(map.containsKey("1")) //이 키 있니:true
    println(map.containsValue("김숙")) //이 값 있니:true
    println(map.get("1")) //이 키인 값 내놔
    //map.clear() //전부 다 지움
    map.remove("1") //이 키인 값 삭제, 키도 같이 없어지네
    map.remove("3535") //없는 키 삭제하려 해도 오류 발생 안함
    map.replace("2", "배고파") //*해당 키 값을 해당 값으로 바꿈, import필요
    println(map.keys)  //*키 다 내놔
    println(map.values) //*값 다 내놔
    val map2 = mutableMapOf(1 to 2, 2 to 3, 3 to 4)
    println(map2)
    for (item in map) {  //향상된 for문으로 출력
        println(item)
    }


    //읽기 전용 이뮤터블(값을 변경할수 없음,교체/삭제/추가 불가) 컬렉션:list
    //자바의 읽기전용 list랑 비슷한듯: List aslist=new ArrayList(list2.subList(0,3));
    //입력된 값을 get()으로 사용만 가능,val로 선언하고 변수명은 대문자로 선언
    val DAY_LIST = listOf("월", "화", "수")
    val DAY_LIST2 = listOf<Int>(1, 2, 3, 4)
    DAY_LIST.get(0)

    val setmu = setOf<Int>(1, 2, 3, 3, 3)
    val mapmu = mapOf<Int, Int>()


}