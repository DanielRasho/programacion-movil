package uvg.edu.gt.myapplication.Model;

public class InfixTranslator {

    fun Prec(c : Char) : Int {
        when (c) {
            '+' -> return 1;
            '-' -> return 1;

            '*' -> return 2;
            '/' -> return 2;

            '^' -> return 3;
        }
        return -1;
    }

    fun infixToPostfix(expression : String) : String {
        var result : String = "";

        var stack : IStack<Char> = Stack();

        for (c in expression){

            if (Character.isLetterOrDigit(c) || c == '.')
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += "," + stack.peek();
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += "," + stack.peek();
                    stack.pop();
                }
                stack.push(c);
                result += ",";
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Expresión inválida";
            result += "," + stack.peek();
            stack.pop();
        }
        return result;
    }
}
