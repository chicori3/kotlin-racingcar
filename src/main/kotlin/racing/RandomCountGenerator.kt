package racing

class RandomCountGenerator : CountGenerator {
    override fun generate(): Int {
        return RANGE.random()
    }

    companion object {
        private val RANGE = 0..9
    }
}
