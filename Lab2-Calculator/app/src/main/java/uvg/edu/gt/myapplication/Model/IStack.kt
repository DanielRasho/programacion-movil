package uvg.edu.gt.myapplication.Model;

public interface IStack<T> {

    fun count() : Int;

    fun isEmpty() : Boolean;

    fun push(value : T);

    fun pull() : T;

    fun peek() : T;
}
