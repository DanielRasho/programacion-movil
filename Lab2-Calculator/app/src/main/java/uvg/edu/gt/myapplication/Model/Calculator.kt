package uvg.edu.gt.myapplication.Model

import java.text.DecimalFormat
import kotlin.math.pow

class Calculator : ICalculator{

    private var previous : Double = 0.0

    /*
    @param s
    @return Boolean
    Identifies if a String is a numeric value
    */
    fun isNumeric(s : String) : Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    /*
    @param expression
    @return Double
    Evaluate the infix expression
     */
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
                    "*" -> stack.push(val2*val1);
                    "^" -> stack.push(val2.pow(val1));
                    "%" -> stack.push(val2%val1)
                    "/" -> stack.push(val2/val1);


                }
            }
        }
        previous = df.format(stack.peek()).toDouble()
        return previous as Double;
    }

    /*
    @return Double
    Obtain the previous result
     */
    override fun getPrevious(): Double {
        return previous
    }
}