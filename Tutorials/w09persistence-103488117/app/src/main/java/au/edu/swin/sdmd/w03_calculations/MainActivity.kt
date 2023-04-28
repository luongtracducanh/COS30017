package au.edu.swin.sdmd.w03_calculations

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var opResult: Int = 0
    private var operator = "plus"

    override fun onStart() {
        super.onStart()
        Log.i("LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFECYCLE", "onPause")
        // shared preferences
        val sharedPref = this.getSharedPreferences("myfile", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            val number1 = findViewById<EditText>(R.id.number1)
            putString("num1", number1.text.toString())
            val number2 = findViewById<EditText>(R.id.number2)
            putString("num2", number2.text.toString())
            val answer = findViewById<TextView>(R.id.answer)
            putString("ans", answer.text.toString())
            putString("operator", operator)
            apply()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFECYCLE", "onRestart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("LIFECYCLE", "onCreate")

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val answer = findViewById<TextView>(R.id.answer)

        // shared preferences
        val sharedPref = this.getSharedPreferences("myfile", Context.MODE_PRIVATE)
        val num1 = sharedPref.getString("num1", "0").toString()
        val num2 = sharedPref.getString("num2", "0").toString()
        operator = sharedPref.getString("operator", "plus").toString()

        number1.setText(num1)
        number2.setText(num2)

        // listener for the button
        /*savedInstanceState?.let {
            opResult = savedInstanceState.getInt("ANSWER")
            answer.text = opResult.toString()
        }*/

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {
            opResult = when(operator) {
                "plus" -> add(number1.text.toString(), number2.text.toString())
                "multiply" -> multiply(number1.text.toString(), number2.text.toString())
                else -> add(number1.text.toString(), number2.text.toString())
            }
            // TODO: show result on the screen
            answer.text = opResult.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ANSWER", opResult)
        Log.i("LIFECYCLE", "saveInstanceState $opResult")
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) = number1.toInt() + number2.toInt()
    private fun multiply(number1: String, number2: String) = number1.toInt() * number2.toInt()

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            // Check which radio button was clicked
            when (view.getId()) {
                R.id.plus -> if (checked) {
                    operator = "plus"
                }
                R.id.multiply -> if (checked) {
                    operator = "multiply"
                }
            }
        }
    }
}