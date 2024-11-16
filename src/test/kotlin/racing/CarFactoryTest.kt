package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarFactoryTest : StringSpec({
    val sut = CarFactory

    beforeTest {
        sut.resetSequence()
    }

    "숫자 생성기를 탑재한 자동차를 생성할 수 있다" {
        val generator = FixedNumberGenerator(4)
        val car = sut.createCar(generator = generator)

        car.position shouldBe 0
    }

    "자동차를 생성할 때마다 부여되는 sequence가 증가한다" {
        val generator = FixedNumberGenerator(4)
        val car1 = sut.createCar(generator = generator)
        val car2 = sut.createCar(generator = generator)

        car1.sequence shouldBe 0
        car2.sequence shouldBe 1
    }
})
