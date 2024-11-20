package racing.domain

data class Result(
    val round: Int,
    val snapShots: List<CarSnapshot>,
) {
    private var maxPosition = snapShots.maxOf(CarSnapshot::position)

    fun getWinnerNames(): List<String> =
        snapShots.filter { it.position == maxPosition }
            .map(CarSnapshot::name)

    companion object {
        fun of(
            round: Int,
            cars: List<Car>,
        ): Result = Result(round, cars.map(CarSnapshot::from))
    }

    data class CarSnapshot(
        val id: Int,
        val name: String,
        val position: Int,
    ) {
        companion object {
            fun from(car: Car): CarSnapshot = CarSnapshot(car.id, car.name, car.getPosition())
        }
    }
}
