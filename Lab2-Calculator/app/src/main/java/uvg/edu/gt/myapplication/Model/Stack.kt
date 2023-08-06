package uvg.edu.gt.myapplication.Model;

import java.util.ArrayList;

public class Stack<T> : IStack<T> {

    private var stack : ArrayList<T> = ArrayList<T>(0);

    public override fun count() : Int {
        return stack.size;
    }

    public override fun isEmpty() : Boolean {
        return stack.isEmpty();
    }

    public override fun push(value : T) {
        stack.add(0, value);
    }

    public override fun pop() : T {
        return stack.removeAt(0);
    }

    override fun peek(): T {
        return stack.get(0);
    }
}
