package uvg.edu.gt.myapplication

import junit.framework.TestCase.assertEquals
import org.junit.Test
import uvg.edu.gt.myapplication.Model.InfixTranslator

class UnitTest {
    var translator : InfixTranslator = InfixTranslator();

    @Test
    fun translationTest() {
        assertEquals("2,6,+,8,/",translator.infixToPostfix("(2+6)/8"))
    }

    @Test
    fun translationTensTest() {
        assertEquals("2,6,^,8,-,9,+,700,*,12,-",translator.infixToPostfix("((2^6-8+9)*700)-12"))
    }

    @Test
    fun translationDecimalsTest() {
        assertEquals("1.2,1,+",translator.infixToPostfix("1.2+1"))
    }

    @Test
    fun translationDecimalsTensParentesisTest() {
        assertEquals("1.2,1,+,98.63,*",translator.infixToPostfix("(1.2+1)*98.63"))
    }
}