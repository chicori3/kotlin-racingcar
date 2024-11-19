package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.domain.Car
import racing.domain.CarFactory

class CarFactoryTest : StringSpec({
    val sut = CarFactory

    beforeTest {
        sut.resetSequence()
    }

    "숫자 생성기를 탑재한 자동차를 생성할 수 있다" {
        val generator = FixedNumberGenerator(4)
        val car = sut.createCar(generator = generator)

        car.getPosition() shouldBe 0
    }

    "자동차를 생성할 때마다 부여되는 id가 증가한다" {
        val generator = FixedNumberGenerator(4)
        val car1 = sut.createCar(generator = generator)
        val car2 = sut.createCar(generator = generator)

        car1.id shouldBe 0
        car2.id shouldBe 1
    }

    "자동차를 생성할 때 이름을 지정할 수 있다" {
        val generator = FixedNumberGenerator(4)
        val name = "sian"
        val car = sut.createCar(generator = generator, name = name)

        car.name shouldBe name
    }

    "여러 이름으로 자동차를 생성할 수 있다" {
        val generator = FixedNumberGenerator(4)
        val names = listOf("sian", "pobi", "crong")
        val cars = sut.createCarsWithNames(generator = generator, names = names)

        cars[0].name shouldBe "sian"
        cars[1].name shouldBe "pobi"
        cars[2].name shouldBe "crong"
    }

    "이름 없이 자동차를 생성하면 이름은 랜덤으로 부여된다" {
        val generator = FixedNumberGenerator(4)
        val cars = sut.createCars(3, generator)

        cars.filter { it.name.isNotBlank() }.map(Car::name).size shouldBe 3
    }
})
