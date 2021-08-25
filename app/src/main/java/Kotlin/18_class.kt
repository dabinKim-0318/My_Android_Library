package Kotlin

//코틀린 class{}에 작성된 변수=멤버변수(프로퍼티)/함수=메서드
//클래스 안에 정의된 메서드 안에 있는 변수=지역변수
// *함수 입력될 값(매개값)=파라미터

//class 클래스명{
//    var 프로퍼티/멤버변수A
//    fun 멤버함수/메서드(){
//        var 지역변수/변수B
//    }
//}
//
//fun 함수(){}

//프라이머리 생성자
//기본 생성자 자바에서 저절로 만들어주는 것처럼  따로 생성자 안만들어주면 코틀린도 기본 생성자 만들어져있는 상태임
//즉 생성자를 작성하지 않을 경우 파라미터가 없는 프라이머리 생성자가 하나 있는 거랑 동일
class Person {}
class Person2 constructor() {}  //생성자에 접근제어자나 다른 옵션 없으면 생략 가능

//프라이머리 생성자의 init:생성자 호출과 동시에 실행
class Person6 {
    init {
        println("프라이머리 생성자 호출시 자동 실행")
    }
}

//프라이머리 생성자도 결국은 함수이기에 파라미터를 받을 수 있음
class Person4 constructor(name: String) {} //이러면 기본 생성자 따로 만들어야되나? yes
class Person5(name: String) {
    //  constructor() 안되네..? 무조건 프라이머리 생성자로만 써야되나?no
    //프라이머리 생성자, 세컨더리 생성자 동시에 생성해도 되지만 세컨더리 생성자 호출시 반드시 기본 생성자
    //호출되도록 this.()로 호출코드 작성!!
}

//프라이머리 생성자로 받은 파라미터를 클래스 전역변수로 사용하기:파라미터 앞에 변수 키워드인 val을 붙임
class Person7(val name: String) {
    fun person() {
        for (item in 0..1) {
            println(name)
        }
    }
}



//세컨더리 생성자
//생성자를 함수처럼 클래스 스코프 안에 직접 작성
//val/var을 이용해 전역변수로 사용 불가! this키워드 사용해야함
//생성된 생성자는 ‘기본 생성자’를 ‘상속' 받아야 한다.
// 그렇기 때문에 기본 생성자를 상속받고 난 이후에는 에러가 사라진 것이다.
// 물론 기본 생성자를 상속 받는 것이니 constructor로 만든 생성자들은 반드시 기본 생성자가
// 갖고 있는 인자들을 갖고 있어야 한다. 그렇지 않으면 또 에러의 늪으로..
class Person3  {
    constructor()
    constructor(name: String)
    constructor(age: Int) //생성자 오버로딩 가능 타입구별 주의!!
    constructor(name: String, age: Int)
}

//세컨더리 생성자 init:어떤 생성자로 호출되든 실행 따라서 세컨더리 생성자로 구현하는 경우 init->생성자 블록 안 실행
class Person9 {
    init {
        println("하이")
    }

    constructor(name: String) {
        println("내이름은 $name 이야")
    }

    constructor(age: Int) {
        println("내 나이는 $age 야")
    }
}

class Person11 {
    var name: String = ""
    var age: Int=0

    constructor(name: String, age: Int){  //constructor(val name: String, val age: Int){  세컨더리 생성자에서는 val선언 불가 this.사용해야 전역변수로 쓸 수있음
        this.name=name
        this.age=age
    }
}

//세컨더리 생성자 호출과 동시에 초기화:init블록없이 {}로 구현
class Person8 {
    constructor(name: String, age: Int) {
        //초기화 내용
    }
}

//생성자 this(): 생성자가 다른 생성자 호출할 때 사용
//class Car(engine:String,body:String){
//    constructor(engine: String,body: String,door:String)
//} 프라이머리 생성자는 생성자 매개값3개인거 호출될때 무조건 같이 호출되어야 하는?
//프라이머리 생성자가 있는 경우 무조건 호출되어야하는듯?

class Car(engine:String,body:String) {
    var door:String=""
    constructor(engine: String, body: String, door: String): this(engine,body){
    this.door=door
    } //세컨더리 생성자 호출하면서 프라이머리 생성자 호출하기
}

class Car2(var engine:String,var body:String) {
    var door:String=""
    constructor(engine: String, body: String, door: String): this(engine,body){
        this.door=door
    } //세컨더리 생성자 호출하면서 프라이머리 생성자 호출하기

    fun function(){
        engine="엔진"
        body="바디"
        door="도어"
    }
}

class Person33 constructor() {
    constructor(name: String):this()
    constructor(age: Int):this()
    constructor(name: String, age: Int):this()
}

fun main(args: Array<String>) {
    Person()
    Person2()
    //Person4() 기본생성자가 있는 거: 무조건 기본생성자 1개로만 호출 가능
    Person4("홍길동")

    Person3() //프라이머리생성자 없는거: 프라이머리 생성자로 호출 불가. 세컨더리 생성자로 호출
    Person3()
    Person3("길동")
    Person3(22)
    Person3("길동", 22)

    val person9Ins: Person9 = Person9("다빈")
    val Person9Ins2 = Person9(24)

    Person7("김").person()

    dabin()


}
//프라이머리 생성자만 있는거->무조건 프라이머리 생성자로 호출
//세컨더리 생성자만 있는거->세컨더리 생성자 오버라이딩 했으면 여러방법으로 생성자 호출+프라이머리에 기본()생성자 없어!! 세컨더리로 따로 만들어
//프라이머리+세컨더리 생성자 둘다 있는거->세컨더리 생성자 호출 시 프라이머리 생성자 무조건 호출되어야 해서 this()사용