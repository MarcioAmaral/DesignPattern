package creationalPatterns
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Calculator {
    fun sum(a: Int, b: Int) = a + b
}

class CalculatorTest {

    @Test
    fun testSum() {
        val calc = Calculator()
        Assertions.assertEquals(8, calc.sum(3, 5))

    }
}