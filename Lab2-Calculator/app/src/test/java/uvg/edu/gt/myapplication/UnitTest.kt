package uvg.edu.gt.myapplication

import junit.framework.TestCase.assertEquals
import org.junit.Test
import uvg.edu.gt.myapplication.Model.InfixTranslator

class UnitTest {
    var translator : InfixTranslator = InfixTranslator();

    @Test
    fun translationTest() {
        assertEquals("20,26,+,8,/",translator.infixToPostfix("(20+26)/8"))
    }

    @Test
    fun translationParentesisTest() {
        assertEquals("2,6,^,8,-,9,+,700,*,12,-",translator.infixToPostfix("((2^6-8+9)*700)-12"))
    }
}