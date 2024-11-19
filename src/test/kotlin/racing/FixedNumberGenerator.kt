package racing

import racing.domain.NumberGenerator

class FixedNumberGenerator(
    private val number: Int,
) : NumberGenerator {
    override fun generate(): Int {
        return number
    }
}
