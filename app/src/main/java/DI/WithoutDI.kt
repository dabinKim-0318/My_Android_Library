package DI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.R

class NormalCar(val engine: Engine, val wheels: Wheels) {
    fun drive() {

    }
}

class Engine(blobk: Block, cylinders: Cylinders, sparkPlugs: SparkPlugs) {}
class Wheels(tires: Tires, rims: Rims) {}

class Block {}
class Cylinders {}
class SparkPlugs {}
class Tires {}
class Rims {}

class WithoutDI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_di)

        val block = Block()
        val cylinders = Cylinders()
        val sparkPlugs = SparkPlugs()
        val tires = Tires()
        val rims = Rims()

        val engine = Engine(block, cylinders, sparkPlugs)
        val wheels = Wheels(tires, rims)

        val normalCar = NormalCar(engine, wheels)
        normalCar.drive()
    }
}