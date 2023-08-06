package uvg.edu.gt.myapplication.Model

interface ICalculator {
    @Throws(ArithmeticException::class)
    fun evaluate(expression: String): Double

    fun getPrevious(): Double
}