package racing

class FixedNumberGenerator(
    private val number: Int,
) : NumberGenerator {
    override fun generate(): Int {
        return number
    }
}
