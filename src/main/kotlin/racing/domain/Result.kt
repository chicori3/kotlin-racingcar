package racing.domain

data class Result(
    val round: Int,
    val cars: List<Car>,
) {
    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOfOrNull(Car::getPosition) ?: return emptyList()
        return cars.filter { it.getPosition() == maxPosition }
    }
}
