package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val equals = findViewById<Button>(R.id.equals)
        val answer = findViewById<TextView>(R.id.answer)
        // listener for the button


        fun onRadioButtonClicked(view: View): Int {
            var temp = 0

            if (view is RadioButton) {
                // Is the button now checked?
                val checked = view.isChecked
                // Check which radio button was clicked
                when (view.getId()) {
                    R.id.plus -> if (checked) {
                        temp = add(
                            Integer.parseInt(number1.text.toString()),
                            Integer.parseInt(number2.text.toString())
                        )
                    }
                    R.id.multiply -> if (checked) {
                        temp = multiply(
                            Integer.parseInt(number1.text.toString()),
                            Integer.parseInt(number2.text.toString())
                        )
                    }
                }
            }
            return temp
        }

        equals.setOnClickListener {
            val _plus = findViewById<RadioButton>(R.id.plus)
            val _muliply = findViewById<RadioButton>(R.id.multiply)
            var result = 0

            if (_plus.isChecked) {
                result = onRadioButtonClicked(_plus)
            } else if (_muliply.isChecked) {
                result = onRadioButtonClicked(_muliply)
            }
            // TODO: show result on the screen
//            val answer = findViewById<TextView>(R.id.answer)
            answer.text = result.toString()
        }
    }

    // adds two numbers together
    private fun add(number1: Int, number2: Int) = number1 + number2
    private fun multiply(number1: Int, number2: Int) = number1 * number2
}