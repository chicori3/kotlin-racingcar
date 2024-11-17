package racing

data class Result(
    val round: Int,
    val carId: Int,
    val name: String,
    val position: Int,
) {
    companion object {
        fun from(
            round: Int,
            car: Car,
        ): Result {
            return Result(
                round = round,
                carId = car.sequence,
                name = car.name,
                position = car.position,
            )
        }
    }
}
