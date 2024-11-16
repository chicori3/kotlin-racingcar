package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class RaceProcessorTest : StringSpec({
    val sut = RaceProcessor

    "입력받은 자동차들과 라운드만큼 레이스를 진행하고 결과를 반환한다" {
        val cars = CarFactory.createCars(3, FixedNumberGenerator(4))
        val round = 5

        val actual = sut.execute(cars, round)

        actual.shouldNotBeNull()
        actual.carCount shouldBe cars.size
        actual.roundCount shouldBe round
    }

    "차의 개수가 0 이하일 경우 IllegalArgumentException을 던진다" {
        val cars = emptyList<Car>()
        val round = 5

        shouldThrow<IllegalArgumentException> {
            sut.execute(cars, round)
        }
    }

    "라운드가 0 이하일 경우 IllegalArgumentException을 던진다" {
        val cars = CarFactory.createCars(3, FixedNumberGenerator(4))
        val round = 0

        shouldThrow<IllegalArgumentException> {
            sut.execute(cars, round)
        }
    }
})
