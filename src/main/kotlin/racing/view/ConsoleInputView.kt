package racing.view

import racing.infrastructure.InputView

class ConsoleInputView : InputView {
    override fun askTryCount() {
        println("시도할 회수는 몇 회 인가요?")
    }

    override fun askNames() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)")
    }

    override fun inputNumber(number: String?): Int {
        val input = validateNumber(number)

        return convertToInt(input)
    }

    override fun inputNames(string: String?): List<String> {
        val input = validateNames(string)

        return convertToNames(input)
    }

    private fun validateNumber(input: String?): String {
        val nonBlankInput = validateBlank(input)
        require(nonBlankInput.matches(Regex(NUMBER_REGEX))) { "0 ~ 9 사이의 숫자만 입력 가능합니다." }

        return nonBlankInput
    }

    private fun validateNames(input: String?): String {
        val nonBlankInput = validateBlank(input)
        require(nonBlankInput.matches(Regex(NAME_REGEX))) { "입력은 쉼표로 구분된 알파벳만 가능합니다." }

        return nonBlankInput
    }

    private fun validateBlank(input: String?): String {
        requireNotNull(input) { "입력이 없습니다." }
        require(input.isNotBlank()) { "입력이 없습니다." }

        return input
    }

    private fun convertToInt(input: String): Int {
        return input.toInt()
    }

    private fun convertToNames(input: String): List<String> {
        return input.trim().split(",")
    }

    companion object {
        const val NUMBER_REGEX = "^[0-9]$"
        const val NAME_REGEX = "^[a-zA-Z,]*$"
    }
}
