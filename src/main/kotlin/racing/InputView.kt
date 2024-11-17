package racing

interface InputView {
    fun askCarQuantity()

    fun askTryCount()

    fun askNames()

    fun inputNumber(number: String?): Int

    fun inputNames(string: String?): List<String>
}
