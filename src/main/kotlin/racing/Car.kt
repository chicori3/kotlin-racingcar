package racing

class Car(
    private var position: Int = 0,
) : Vehicle {
    fun getPosition(): Int {
        return this.position
    }

    override fun move(count: Int) {
        if (isMoveable(count)) {
            this.position += 1
        }
    }

    private fun isMoveable(count: Int): Boolean {
        return count >= 4
    }

    companion object {
        fun from(position: Int): Car {
            require(position >= 0) { "시작 위치는 0 이상이어야 합니다." }
            return Car(position)
        }
    }
}
