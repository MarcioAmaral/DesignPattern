import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

sealed class Country {
    object Canada : Country()
}

object Spain : Country()
class Greece(val someProperty: String) : Country()
data class USA(val someProperty: String) : Country()

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
            when (country) {
                is Spain -> Currency("EUR")
                is Greece -> Currency("EUR")
                is USA -> Currency("USD")
                is Country.Canada -> Currency("CAD")
            }
}

class FactoryTest {
    @Test
    fun testFactoryMethod() {
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        Assertions.assertEquals("EUR", greekCurrency)

        val canadaCurrency = CurrencyFactory.currencyForCountry(Country.Canada).code
        Assertions.assertEquals("CAD", canadaCurrency)
    }
}
