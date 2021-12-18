package designpattern

/*<생성패턴>
생성패턴은 인스턴스를 만드는 절차를 추상화하는 패턴이다
생성패턴에 속하는 패턴들은 객체를 생성, 합성하는 방법이나 객체의 표현 방법을 시스템과 분리해준다
생성패턴은 시스템이 상속보다 복잡한 방법을 사용하는 방향으로 진화되어 가면서 더 중요해지고 있다
- 생성패턴의 중요한 2가지 이슈
1.생성패턴은 시스템이 어떤 Concrete Class를 사용하는지에 대한 정보를 캡슐화한다
2.생성패턴은 이들 클래스의 인스턴스들이 어떻게 만들고 결합하는지에 대한 부분을 완전히 가려준다
=>생성패턴을 이용하면 무엇이 생성되고 누가 이것을 생성하고 이게 어떻게 생성되고 언제 생성될지 결정하는 데 유연성 확보!

<팩토리 패턴>
팩토리 패턴은 생성패턴중 하나다*/

//Super Class
abstract class Computer {
    abstract fun getRAM(): String
    abstract fun getHDD(): String
    abstract fun getCPU(): String

    override fun toString(): String {
        return "RAM= " + getRAM() + ", HDD=" + getHDD() + ", CPU=" + getCPU()
    }
}

//sub Class1
class PC(private val ram: String, private val hdd: String, private val cpu: String) : Computer() {
    override fun getRAM(): String {
        return ram
    }

    override fun getHDD(): String {
        return hdd
    }

    override fun getCPU(): String {
        return cpu
    }
}

//sub Class2
class Server(private val ram: String, private val hdd: String, private val cpu: String) : Computer() {
    override fun getRAM(): String {
        return ram
    }

    override fun getHDD(): String {
        return hdd
    }

    override fun getCPU(): String {
        return cpu
    }
}

//Factory Class->static 메서드가 인스턴스를 만들어서 전달하는데 이때, 인스턴스의 타입만 전달하면됨
//Computer을 상속하는 많은 서브클래스가 생겨도 나는 Sub클래스의 정보를 모른채 그냥 타입이랑 인자주면
//해당 타입의 인스턴스를 만들어준다
class ComputerFactory {
    companion object {
        fun getComputer(type: String?, ram: String?, hdd: String?, cpu: String?): Computer? {
            if ("PC".equals(type, ignoreCase = true))
                return PC(ram!!, hdd!!, cpu!!)
            else if ("Server".equals(type, ignoreCase = true))
                return Server(ram!!, hdd!!, cpu!!)
            return null
        }
    }
}

//서브클래스 자체를 인스턴스화해서 가져오는 코드가 아니라 팩토리패턴으로 한번 감싸서 인스턴스를 얻으니까\
//서로간의 종속성을 낮추고 결합도를 느슨하게 하고 확장을 쉽게함
class test {
    val factory = ComputerFactory.getComputer("PC", "", "", "")
    val nomal = PC("", "", "")
}