package uvg.edu.gt.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uvg.edu.gt.myapplication.Model.Calculator
import uvg.edu.gt.myapplication.Model.ICalculator
import uvg.edu.gt.myapplication.Model.InfixTranslator
import uvg.edu.gt.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    var calculator: ICalculator = Calculator();
    var currentOperation : String = ""
    var lastOperation : String = ""

    var operationTxt : TextView ? = null;
    var previewTxt : TextView ? = null;

    var divisionBtn: Button ? = null;
    var multiplicationBtn: Button ? = null;
    var addBtn : Button ? = null;
    var minusBtn: Button ? = null;
    var powerBtn: Button ? = null;
    var moduleBtn: Button ? = null;

    var answerBtn: Button ? = null;
    var deleteBtn: Button ? = null;
    var equalBtn: Button ? = null;

    var nineBtn: Button ? = null;
    var eightBtn: Button ? = null;
    var sevenBtn: Button ? = null;
    var sixBtn: Button ? = null;
    var fiveBtn: Button ? = null;
    var fourBtn: Button ? = null;
    var threeBtn: Button ? = null;
    var twoBtn: Button ? = null;
    var oneBtn: Button ? = null;
    var zeroBtn: Button ? = null;
    var pointBtn: Button ? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeTextLabel()
        initializeMiscOperators()
        initializeOperators()
        initializeNumberBtn()
        addOnClick()
    }

    private fun addOperator(value: String){
        currentOperation += value;
        previewTxt?.text = currentOperation;
    }

    private fun addOnClick(){

        equalBtn?.setOnClickListener{
            var result : Double = calculator.evaluate(currentOperation)
            lastOperation = result.toString()
            currentOperation = ""
            operationTxt?.text = lastOperation
            previewTxt?.text = currentOperation
        }

        deleteBtn?.setOnClickListener {
            if (currentOperation.isNotEmpty())
                currentOperation = currentOperation.substring(0, currentOperation.length - 1);
            previewTxt?.text = currentOperation;
        }

        answerBtn?.setOnClickListener {
            if (lastOperation.isNotEmpty())
                addOperator(lastOperation)
        }

        divisionBtn?.setOnClickListener{
            addOperator("/")
        }
        moduleBtn?.setOnClickListener{
            addOperator("%")
        }
        powerBtn?.setOnClickListener{
            addOperator("^")
        }
        multiplicationBtn?.setOnClickListener{
            addOperator("*")
        }
        addBtn?.setOnClickListener{
            addOperator("+")
        }
        minusBtn?.setOnClickListener{
            addOperator("-")
        }

        nineBtn?.setOnClickListener{
            addOperator("9")
        }
        eightBtn?.setOnClickListener{
            addOperator("8")
        }
        sevenBtn?.setOnClickListener{
            addOperator("7")
        }
        sixBtn?.setOnClickListener{
            addOperator("6")
        }
        fiveBtn?.setOnClickListener{
            addOperator("5")
        }
        fourBtn?.setOnClickListener{
            addOperator("4")
        }
        threeBtn?.setOnClickListener{
            addOperator("3")
        }
        twoBtn?.setOnClickListener{
            addOperator("2")
        }
        oneBtn?.setOnClickListener{
            addOperator("1")
        }
        zeroBtn?.setOnClickListener{
            addOperator("0")
        }
        zeroBtn?.setOnClickListener{
            addOperator(".")
        }
    }

    private fun initializeMiscOperators(){
        equalBtn = findViewById(R.id.equals)
        answerBtn = findViewById(R.id.ans)
        deleteBtn = findViewById(R.id.del)
    }

    private fun initializeTextLabel(){
        operationTxt = findViewById(R.id.operation)
        previewTxt = findViewById(R.id.preview)
    }

    private fun initializeOperators(){
        divisionBtn = findViewById(R.id.div)
        moduleBtn = findViewById(R.id.mod)
        multiplicationBtn = findViewById(R.id.mul)
        powerBtn = findViewById(R.id.potent)
        addBtn = findViewById(R.id.plus)
        minusBtn = findViewById(R.id.minus)
    }

    private fun initializeNumberBtn(){
        nineBtn = findViewById(R.id.nine)
        eightBtn = findViewById(R.id.eight)
        sevenBtn = findViewById(R.id.seven)
        sixBtn = findViewById(R.id.six)
        fiveBtn = findViewById(R.id.five)
        fourBtn = findViewById(R.id.four)
        threeBtn = findViewById(R.id.three)
        twoBtn = findViewById(R.id.two)
        oneBtn = findViewById(R.id.one)
        zeroBtn = findViewById(R.id.zero)
        pointBtn = findViewById(R.id.point)
    }
}