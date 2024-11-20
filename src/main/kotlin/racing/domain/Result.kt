package racing.domain

data class Result(
    val round: Int,
    val cars: List<CarSnapshot>,
) {
    fun getWinnerNames(): List<String> {
        val lastResult = cars.maxByOrNull(CarSnapshot::position) ?: return emptyList()

        return cars.filter { it.position == lastResult.position }
            .map(CarSnapshot::name)
    }

    companion object {
        fun of(
            round: Int,
            cars: List<Car>,
        ): Result {
            return Result(round, cars.map(CarSnapshot::from))
        }
    }

    data class CarSnapshot(
        val id: Int,
        val name: String,
        val position: Int,
    ) {
        companion object {
            fun from(car: Car) = CarSnapshot(car.id, car.name, car.getPosition())
        }
    }
}
