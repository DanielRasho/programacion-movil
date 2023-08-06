package uvg.edu.gt.myapplication.Model;

import java.util.ArrayList;

public class Stack<T> : IStack<T> {

    private var stack : ArrayList<T> = ArrayList<T>(0);

    /*
    @return Int
    Shows the stack's size
     */
    public override fun count() : Int {
        return stack.size;
    }

    /*
    @return Boolean
    Indicates if the stack is empty
     */
    public override fun isEmpty() : Boolean {
        return stack.isEmpty();
    }

    /*
    @param T
    Puts a value into the stack
     */
    public override fun push(value : T) {
        stack.add(0, value);
    }

    /*
    Remove the element of the stack
     */
    public override fun pop() {
        stack.removeAt(0);
    }

    /*
    @return T
    Gets the value from the stack
     */
    override fun peek(): T {
        return stack.get(0);
    }
}
