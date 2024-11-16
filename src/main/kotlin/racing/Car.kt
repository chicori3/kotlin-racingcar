package racing

class Car private constructor(
    sequence: Int,
    position: Int,
) : Vehicle {
    var sequence: Int = sequence
        private set
    var position: Int = position
        private set

    override fun move(count: Int) {
        if (isMoveable(count)) {
            this.position += 1
        }
    }

    private fun isMoveable(count: Int): Boolean {
        return count >= MOVEABLE_COUNT
    }

    init {
        require(this.position >= 0) { "시작 위치는 0 이상이어야 합니다." }
    }

    companion object {
        fun from(
            sequence: Int,
            position: Int,
        ): Car {
            return Car(sequence, position)
        }

        private const val MOVEABLE_COUNT = 4
    }
}
