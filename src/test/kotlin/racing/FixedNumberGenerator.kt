package racing

class FixedNumberGenerator(
    private val number: Int,
) : CountGenerator {
    override fun generate(): Int {
        return number
    }
}
