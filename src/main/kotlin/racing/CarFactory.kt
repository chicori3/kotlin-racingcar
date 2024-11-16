package racing

object CarFactory {
    private var sequence: Int = 0

    fun createCar(
        position: Int = 0,
        generator: NumberGenerator,
    ): Car {
        return Car.from(
            sequence = sequence++,
            position = position,
            generator = generator,
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

    fun resetSequence() {
        sequence = 0
    }
}
