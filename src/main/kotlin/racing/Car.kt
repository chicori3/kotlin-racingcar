package racing

class Car private constructor(
    sequence: Int,
    position: Int,
    private var generator: NumberGenerator,
) : Vehicle {
    var sequence: Int = sequence
        private set
    var position: Int = position
        private set

    init {
        require(this.position >= 0) { "시작 위치는 0 이상이어야 합니다." }
    }

    override fun move() {
        if (isMoveable()) {
            this.position += 1
        }
    }

    private fun isMoveable(): Boolean {
        return generator.generate() >= MINIMUM_MOVABLE_THRESHOLD
    }

    companion object {
        fun from(
            sequence: Int,
            position: Int,
            generator: NumberGenerator,
        ): Car {
            return Car(
                sequence = sequence,
                position = position,
                generator = generator,
            )
        }

        private const val MINIMUM_MOVABLE_THRESHOLD = 4
    }
}
