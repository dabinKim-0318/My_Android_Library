package DI

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject


class withDI : AppCompatActivity() {
    //  @Inject
    lateinit var hero: Hero
    lateinit var person: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_di)

        /*  HeroComponent interface를 만들었으니 Dagger는
          DaggerHeroComponent란 class를 자동 생성
          Component는 builder pattern을 이용하기 때문에 create() 대신에
          마지막에 주석으로 처리해 놓은 builder().build()를 호출해도 상관은 없습니다.
          val hero2 = DaggerHeroComponent.builder().build().callHero()*/
        // val hero2: Hero = Hero()
        //  hero = DaggerHeroComponent.create().inject(hero2)
        person=DaggerHeroComponent.create().callPerson()
        Log.d("MyTag", person.name());
        hero=DaggerHeroComponent.create().callHero()
        Log.d("MyTag", hero.person.skill());

    }
}

class IronMan : Person {
    override fun name() = "토니 스타크"
    override fun skill() = "수트 변형"
}

class Suit : Weapon {
    override fun type() = "수트"
}


interface Person {
    fun name(): String
    fun skill(): String
}

interface Weapon {
    fun type(): String
}


/*Component에서 Hero 객체 자체를 생성합니다.
따라서 Hero 객체는 Dagger에 의해 생성되는 대상이며, Dagger가 Hero를 생성할때 필요한 생성자의 인자들을 채워 넣어야 합니다.
이를 Dagger에게 알려주기 위해서 아래와 같이 Hero 클래스를 수정합니다.*/
class Hero @Inject constructor(val person: Person, val weapon: Weapon) {
    fun info() {
        Log.d("doo", "name: ${person.name()} skill: ${person.skill()} | weapon:${weapon.type()}")
    }
}

//module은 객체를 생성해서 공급해주는 역할
//HeroModule에 세개의 provider를 정의하여 새개의 클래스에 대한 객체 생성을 정의
//클래스명에는 Module이 suffix로, 함수명은 provide가 prefix로 붙도록 권장하고 있습니다.
@Module
class HeroModule {
    @Provides
    fun providePerson(): Person = IronMan()

    @Provides
    fun provideWeapon(): Weapon = Suit()

    //"Hero에 인자로 들어가는 객체는 어떻게 지정하지?" 란 의문점이 있을수 있으나,
    // @Provides로 제공하는 함수들의 반환타입을 보고
    // Dagger 알아서 해당 함수를 찾아 호출하여 객체를 생성해서 넣어줍니다.
    @Provides
    fun provideHero(person: Person, weapon: Weapon) = Hero(person, weapon)
}

/*component는 객체를 생성하기 위해 제공되는 interface 입니다.
즉, 실제로 객체를 생성 해야하는 부분에서는 module이 아닌, component를 호출하여 객체를 생성
이때 annotation의 인자값으로 어떤 모듈을 이용할지 모듈 정보를 "modules="에 넣어 줍니다.
여기서는 한개만 넣었으나, 다수의 Module인 경우 "," 로 구분하여 넣어줍니다.
interface의 구성요소로는 외부에서 객체를 생성하기 위해 호출해야 할 함수를 정의 합니다.
함수명은 상관없으며, 생성할 객체가 Hero이기 때문에 return값이 Hero인 abstract 함수를 하나 만들어 둡니다.
component는 interface로 구성됩니다.
따라서 Dagger가 해당 구성요소를 보고 실제 concrete 한 클래스를 자동 생성 합니다.*/
@Component(modules = [HeroModule::class])
interface HeroComponent {
    fun callHero(): Hero
    fun callPerson(): Person
    fun callWeapon(): Weapon
    //fun inject(hero: Hero): Hero
}


/*
class Hero() {
    @Inject
    lateinit var person: Person

    @Inject
    lateinit var weapon: Weapon

    fun info() {
        Log.d("doo", "name: ${person.name()} skill: ${person.skill()} | weapon:${weapon.type()}")
    }
}
*/

/*이로써 Dagger가 객체를 주입해야하는 위치를 선정해 줬고,
주입해야 하는 객체를 생성하는 방법을 Module에 기술했으며,
자동 생성하기 위해 caller에게 노출할 함수까지 component에 정의하여 전부 준비가 완료 되었습니다.
Dagger를 이용하여 객체를 생성하는 부분을 작업하기에 앞서 Dagger작업한 Module과 Component를 연결하고 concrete 한 클래스를 생성해야 합니다.
따라서 프로젝트를 한번 rebuild해 줍니다.*/



