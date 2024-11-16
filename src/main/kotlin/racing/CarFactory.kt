package racing

object CarFactory {
    private var sequence: Int = 0

    fun createCar(
        position: Int = 0,
        generator: CountGenerator,
    ): Car {
        return Car.from(
            sequence = sequence++,
            position = position,
            generator = generator,
        )
    }

    fun createCars(
        quantity: Int,
        generator: CountGenerator,
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
