package racing.infrastructure

import racing.domain.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return RANGE.random()
    }

    companion object {
        private val RANGE = 0..9
    }
}
