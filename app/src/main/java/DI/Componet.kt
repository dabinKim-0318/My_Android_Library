package DI

import dagger.Component
import dagger.Module
import javax.inject.Inject

class NormalCar2 @Inject constructor(val engine: Engine2, val wheels: Wheels2) {
    fun drive() {

    }
}

class Engine2 @Inject constructor(blobk: Block, cylinders: Cylinders, sparkPlugs: SparkPlugs) {

}

class Wheels2 @Inject constructor(tires: Tires, rims: Rims) {

}

/*class Block {}
class Cylinders {}
class SparkPlugs {}
class Tires {}
class Rims {}*/


@Component
interface CarComponet {

}

//필요한 객체를 제공하는 역활을 합니다.
@Module
class CarModule {

}