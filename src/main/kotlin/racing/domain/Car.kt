package racing.domain

class Car(
    val id: Int,
    val name: String,
    val position: CarPosition,
) : Vehicle {
    init {
        require(name.length <= 5) { "이름은 5자 이하여야 합니다." }
    }

    override fun move() {
        position.move()
    }

    fun getPosition() = position.value

    companion object {
        fun from(
            id: Int,
            name: String = "",
            position: Int,
            generator: NumberGenerator,
        ): Car {
            val carPosition = CarPosition(generator, position)
            return Car(
                id = id,
                name = name,
                position = carPosition,
            )
        }
    }
}
