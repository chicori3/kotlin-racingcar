package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InputViewTest : StringSpec({
    "숫자 입력이 없으면 예외가 발생한다" {
        val inputView = ConsoleInputView()

        val exception =
            shouldThrow<IllegalArgumentException> {
                inputView.inputNumber(null)
            }

        exception.message shouldBe "입력이 없습니다."
    }

    "0 ~ 9 사이의 숫자가 아니면 예외가 발생한다" {
        val inputView = ConsoleInputView()

        val exception =
            shouldThrow<IllegalArgumentException> {
                inputView.inputNumber("a")
            }

        exception.message shouldBe "0 ~ 9 사이의 숫자만 입력 가능합니다."
    }

    "쉼표로 구분되는 이름을 입력할 수 있다" {
        val inputView = ConsoleInputView()

        val names = inputView.inputNames("sian,pobi,crong")

        names shouldBe listOf("sian", "pobi", "crong")
    }

    "이름 입력이 없으면 예외가 발생한다" {
        val inputView = ConsoleInputView()

        val exception =
            shouldThrow<IllegalArgumentException> {
                inputView.inputNames(null)
            }

        exception.message shouldBe "입력이 없습니다."
    }

    "이름 입력 시 쉼표와 알파벳 이외의 문자가 있으면 예외가 발생한다" {
        val inputView = ConsoleInputView()

        val exception =
            shouldThrow<IllegalArgumentException> {
                inputView.inputNames("sian,pobi,crong,1")
            }

        exception.message shouldBe "입력은 쉼표로 구분된 알파벳만 가능합니다."
    }
})
