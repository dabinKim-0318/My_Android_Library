package Kotlin

//object class로 선언하면 클래스를 생성자로 인스턴스화 하지 않아도 블록 안의 프로퍼티와 메서드를 호출해서 사용 가능
//자바 static이랑 비슷한데 class자체에 static을 붙여버림
//걍 클래스의 모든 멤버들이 static특성 갖는거라 생각하면됨 클래스소속되니까 1개만 생성되고
//object Pig constructor(name:String){} 객체없이 바로 접근하니가 생성자 당연히 못만듦

object Animal {

    var name = "홍길동"
    fun pig(name: String) {
        println(name)
    }
}

fun String.plus2(word: String): String {
    return this + word
}


//companion object: static멤버를 한데 모아 코드블럭으로 묶어두기!
class Family {
    companion object {
        var number = 4
        var name = "백김치"
    }

    var happy = "yes"
}

//상속 대상이 되는 class는 open 키워드로 만들어야 자식 클래스에서 사용 가능
open class Base {}
class Child(name: String) : Base() {}
//class 자식클래스11:부모클래스(){   자식은 세컨더리 생성자로 호출해놓곤 부모는 프라이머리로 호출할라해서 안되는 듯
//    constructor()
//    constructor(name:String)
//}


//부모 생성자 파라미터가 있는 클래스의 상속
//부모class에 있는 생성자가 프라이머리 생성자든, 세컨더리 생성자든 자식이 부모 생성자 호출할때 프라이머리,세컨더리에서 같이! 호출해주면됨
open class Base2(value: String) {}

class Child2(value: String, name: String) : Base2(value) {}  //자식클래스 생성시 입력하는 파라미터를 전달하는 개념
class Child22(value: String) : Base2(value) {}
class Child222 : Base2 {
    constructor(name: String) : super(name)
}
//class Child33(val value:String):Base2{
//    super(value)
//}

open class Base333 {    //부모 클래스는 open되어 있어야함
    constructor()
}

class Child3333: Base333() {}

class Childd:Base333{
    constructor(name:String):super()
}
class Childdd:Base333(){
  //  constructor():Base333()
}
class Childddd(name:String):Base333(){}

//부모 생성자에 세컨더리 파라미터가 있는 클래스의 상속
open class Base3 {
    constructor(name: String) {}
}

class Child3(name: String) : Base3(name) {}
class Child4 : Base3 {
    constructor(name: String) : super(name)
}


//메서드,필드 오버라이드할때 부모클래스 open돼있어야하고 오버라이딩될 메서드랑 필드 둘다 open되어있어야 가능함
open class BaseClass {
    open fun opend() {}
    open var open = 6
    fun notOpend() {}
}

class ChildClass : BaseClass() {
    override fun opend() {} //오버라이딩 할때 앞에 override작성!
    override var open = 7
    //override fun notOpend() open되어 있지 않아서 오버라이딩 불가능
}

open class Car22 {
    open fun drive(): String {
        return "달린다"
    }
}

class superCar : Car22() {
    override fun drive(): String {
        return "빨리 ${super.drive()}"
    }
}

//익스텐션: 이미 만들어져있는 클래스,메서드,프로퍼티에 대해 익스텐션을 지원
//상속이 미리 만들어져 있는 클래스를 가져다 쓰는 개념이라면, 익스텐션은 미리 만들어져 있는 클래스에 메서드를 넣는 개념
//자신이 만든 클래스에 사용하기 보다는 누군가 작성해둔 이미 컴파일되어 있는 클래스에 메서드를 추가하는 용도로 많이 사용
//익스텐션을 사용한다고 해서 실제 클래스의 코드가 변경되는 것은 아님. 단지 실행 시 도트 연산자로 호출해서 사용할 수 있도록 함
//거의 메서드 확장 용도로 사용


fun String.plus(word: String): String {
    return this + word
}

fun main(args: Array<String>) {
    println(Animal.name)  //클래스 이름.변수
    Animal.pig("돼지") //클래스 이름.메서드

    Family.name
    //Family.happy
    Family().happy

    var nice = "안녕"
    println(nice.plus("반가워"))  //안녕 반가워
}