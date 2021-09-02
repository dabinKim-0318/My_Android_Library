package Kotlin

class Book(var name: String, var price: Int) {
    fun discount() {
        price - +2000
    }
}


//apply:메인함수안에서 별도의 코드블록으로 인스턴스의 변수와 함수 조작하므로 코드가 깔끔해짐
//run:apply처럼 run스코프 안에서 참조연산자를 사용하지 않아도 된다는 공통점이 있지만
//일반 람다함수처럼 인스턴스를 반환하는게 아니라 마지막 구문의 결과값을을 return함
//이미 인스턴스가 만들어진 후에 그 안에 있는 속성을 스코프 내에서 사용해야 할때 유용
fun main() {


    var price=5000
    var a: String = "초특가" + Book("다빈의 코틀린", 4000).name
    println(a)
    //이렇게도 가능한데 이렇게 하면 a는 String을 반환+코드드럽

    var apply: Book = Book("다빈의 자바", 4000).apply {
        "초특가"+this.name
        this.discount()
    } //apply의 스코프 안에서 직접 인스턴스의 속성과 함수 조작 가능 이때 참조연산자가 필요없고 인스턴스 자신을 바로 반환해줌
    //객체 생성하자마자 조작한다음에 객체 바로 변수에 넣기 가능

    var also: Book = Book("다빈의 자바", 4000).also { target->
        target.name + "초특가"
        target.discount()
    }

    val run = Book("다빈의 자바", 4000).run {
        name = "지태의 자바스크립트"
        price = -2000
        name + price //마지막구문의 결과값을 return
    }

    val let = Book("다빈의 자바", 4000).let { item->
        item.name = "지태의 자바스크립트"
        item.price = -2000
        item.name + item.price //마지막구문의 결과값을 return
    }

    //처리가 끝나면 인스턴스를 반환:apply,also
    //처리가 끝나면 최종값을 반환:run,let
    //apply랑 run은 참조연산자 없이 인스턴스의 변수와 함수를 사용할 수 있었는데 run,let은 굳이 참조연산자(파라미터)it를 쓰는 이유?
    //같은 이름의 변수나 함수가 스코프 밖에 중복되어있는 경우에 혼란을 방지하려고
//main최상단에 있는 price를 선언하면 인스턴스의 price가 아니라 main함수에서 만든 price가 호출됨
    //이는 run,let함수가 인스턴스 내의 price속성보다 main에 속한 변수가 우선됨



    val list= mutableListOf<String>("가","나").run{
        val listsize=this.size
            listsize
    }
    println(list)
}
