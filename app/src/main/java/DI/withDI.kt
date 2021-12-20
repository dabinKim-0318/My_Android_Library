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
    @Inject
    lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_di)

         hero = DaggerHeroComponent.create().callHero()
        Log.d("MyTag",hero.person.name());

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


@Module
class HeroModule {
    @Provides
    fun providePerson(): Person = IronMan()

    @Provides
    fun provideWeapon(): Weapon = Suit()

    @Provides
    fun provideHero(person: Person, weapon: Weapon) = Hero(person, weapon)
}

@Component(modules = [HeroModule::class])
interface HeroComponent {
    fun callHero(): Hero
}

class Hero @Inject constructor(val person: Person, val weapon: Weapon) {
    fun info() {
        Log.d("doo", "name: ${person.name()} skill: ${person.skill()} | weapon:${weapon.type()}")
    }
}


