package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "Alice", age = 20, nickname = "Alice")
        assertThat(actual.name).isEqualTo("Alice")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("Alice")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "Alice", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본값`() {
        val actual = Person(name = "Alice", age = 20)
        assertThat(actual.nickname).isEqualTo("Alice")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "Alice", age = 20)
        val person2 = Person(name = "Alice", age = 20)
        assertThat(person1).isEqualTo(person2)
    }
}
