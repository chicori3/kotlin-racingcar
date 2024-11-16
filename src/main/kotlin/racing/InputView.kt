package racing

interface InputView {
    fun askCarQuantity()

    fun askTryCount()

    fun inputNumber(number: String?): Int
}
