package Kotlin

abstract class Player {
    abstract fun play()
    abstract fun stop()
    fun custom() {
        play()
    }
}

abstract class Mp3 : Player() {
    override fun play() {}
}

class Mp4 : Player() {
    override fun play() {}
    override fun stop() {}
}

interface inter {
    companion object {
        const val CONST_VAL: String = "자기소개" //상수는 인터페이스 안에서 초기화 되어있어야함
        var filed: String = ""
        val filed2: Int = 5
        fun name() {
            println("static에서 바로 호출")
        }  //자바에서 처럼 static한 메서드도 선언 가능 이때 구현부{}있어야함
    }


    var variable: String       //코틀린은 인터페이스 내부에서 프로퍼티도 정의 가능
    val variable2: String      //코틀린은 인터페이스 내부에서 프로퍼티도 정의 가능
    fun bye()
    fun hi() {                 //default메서드는 구현부를 통해 바로 정의 가능
        println("default메서드는 바로 만들 수 있음")
    }
}

interface Student {
    val nickName: String  //프로퍼티만 있는 경우 구현 필요
    val phone: Int     //인터페이스 프로퍼티에 커스텀get구현시 오버라이딩해서 구현해줄 필요 없음
        get():Int {
            return 10
        }
    //val age:Int=22 인터페이스에서는 초기화 불가
}

class StudentInfo : Student {
    override val nickName: String = ""
    //구현하면 get()이 자동생성됨
}

class StudentInfo2(val age: Int) : Student {
    override val nickName: String = "" //오버라이딩 하고 나서 get커스터마이징 가능
        get() {
            return field + "저의 나이는 $age 입니다"
        }
}

class StudentInfo3 : Student {
    override val nickName: String = ""  //반드시 구현
    //override val phone:Int=0    //구현 필요없음
}


fun main(args: Array<String>) {
    //Player()
    val myplay: Player = Mp4()
    myplay.play()

    println(StudentInfo2(24).nickName) //반갑습니다저의 나이는 24 입니다

}
