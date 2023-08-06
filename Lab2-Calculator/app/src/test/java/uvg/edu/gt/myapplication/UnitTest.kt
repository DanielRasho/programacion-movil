package uvg.edu.gt.myapplication

import junit.framework.TestCase.assertEquals
import org.junit.Test
import uvg.edu.gt.myapplication.Model.Calculator
import uvg.edu.gt.myapplication.Model.ICalculator
import uvg.edu.gt.myapplication.Model.InfixTranslator

class UnitTest {
    var translator : InfixTranslator = InfixTranslator();
    var calculator : ICalculator = Calculator();

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

    @Test
    fun translationPowerTest() {
        assertEquals("2,3,^",translator.infixToPostfix("2^3"))
    }

    @Test
    fun CalculatorAddTest() {
        assertEquals(2.0,calculator.evaluate("1+1"))
    }

    @Test
    fun CalculatorAddDecimalTest() {
        assertEquals(3.4,calculator.evaluate("1.8+1.6"))
    }

    @Test
    fun CaltulatorDecimalsTensParentesisTest() {
        assertEquals(216.99,calculator.evaluate("(1.2+1)*98.63"))
    }

    @Test
    fun RoundDownTest() {
        assertEquals(1.41,calculator.evaluate("1.3+0.111"))
    }

    @Test
    fun RoundUpTest() {
        assertEquals(1.63,calculator.evaluate("1.32+0.308"))
    }

    @Test
    fun calculatorTensTest() {
        assertEquals(4468.0,calculator.evaluate("2^6*70-12"))
    }

    @Test
    fun calculatorPowerTest() {
        assertEquals(64.0,calculator.evaluate("2^6"))
    }

    @Test
    fun PreviousTest() {
        calculator.evaluate("2^6")
        calculator.evaluate("1000*2")
        assertEquals(2000.0,calculator.getPrevious())
    }
}