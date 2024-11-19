package racing.domain

class CarPosition(
    private val generator: NumberGenerator,
    value: Int,
) {
    var value: Int = value
        private set

    init {
        require(this.value >= 0) { "시작 위치는 0 이상이어야 합니다." }
    }

    fun move() {
        if (isMoveable()) {
            this.value += 1
        }
    }

    private fun isMoveable(): Boolean {
        return generator.generate() >= MINIMUM_MOVABLE_THRESHOLD
    }

    companion object {
        private const val MINIMUM_MOVABLE_THRESHOLD = 4
    }
}
