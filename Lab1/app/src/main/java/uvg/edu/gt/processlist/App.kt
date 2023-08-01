package uvg.edu.gt.processlist

fun main(){

}

class App {

    fun processList(items:List<Any>?): List<Any>?{
        var list : List<Any>? = null;
        return list;
    }

}

class ItemData <T>{
    var originalPos : Int;
    var originalValue : T;
    var type : String?;
    var info : String?;
    constructor(position:Int, value: T, ){
        originalPos = position;
        originalValue = value;
        type = setType();
        info = setInfo();
    }

    private fun setType() : String{
        if (this.originalValue is Int)
            return "entero";
        else if (this.originalValue is String)
            return "cadena"
        else if (this.originalValue is Boolean)
            return "boolean"
        else
            return null;
    }

    private fun setInfo() : String{
        if (this.originalValue is Int)
            if(this.originalValue % 10 == 0)
                return
        else if (this.originalValue is String)
            return "cadena"
        else if (this.originalValue is Boolean)
            return "boolean"
        else
            return null;
    }
}