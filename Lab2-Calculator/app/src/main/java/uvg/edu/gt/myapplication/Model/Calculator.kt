package uvg.edu.gt.myapplication.Model

import androidx.core.text.isDigitsOnly
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class Calculator : ICalculator{

    private var previous : Double = 0.0
    fun isNumeric(s : String) : Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    override fun evaluate(expression: String): Double {
        var stack : Stack<Double> = Stack();
        val df = DecimalFormat("#.##");
        //df.roundingMode = RoundingMode.UP
        var translator : InfixTranslator = InfixTranslator();
        var array : List<String> = translator.infixToPostfix(expression).split(",");

        for (v in array){
            if (isNumeric(v))
                stack.push(v.toDouble())

            else {
                var val1 : Double = stack.peek();
                stack.pop();
                var val2 : Double = stack.peek();
                stack.pop();

                when (v) {
                    "+" -> stack.push(val2+val1);
                    "-" -> stack.push(val2-val1);
                    "/" -> stack.push(val2/val1);
                    "*" -> stack.push(val2*val1);
                    "^" -> stack.push(val2.pow(val1));

                }
            }
        }
        previous = df.format(stack.peek()).toDouble()
        return previous as Double;
    }

    override fun getPrevious(): Double {
        return previous
    }
}