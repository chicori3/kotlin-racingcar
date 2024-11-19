package racing.domain

object CarFactory {
    private var sequence: Int = 0
    private val RANDOM_NAMES =
        listOf(
            "Avell", "Brad", "Brani", "Burga", "Farad", "Gocet", "More", "Prest", "Talis",
        )

    fun createCar(
        position: Int = 0,
        generator: NumberGenerator,
        name: String = RANDOM_NAMES.random(),
    ): Car {
        return Car.from(
            id = sequence++,
            position = position,
            generator = generator,
            name = name,
        )
    }

    fun createCars(
        quantity: Int,
        generator: NumberGenerator,
    ): List<Car> {
        return (0 until quantity).map {
            createCar(
                generator = generator,
            )
        }
    }

    fun createCarsWithNames(
        names: List<String>,
        generator: NumberGenerator,
    ): List<Car> {
        return names.map { name ->
            createCar(
                generator = generator,
                name = name,
            )
        }
    }

    fun resetSequence() {
        sequence = 0
    }
}
