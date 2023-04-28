package au.edu.swin.sdmd.w06_multiplessolutions

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factor1 = Random.nextInt(from = 1, until = 13)
        val factor2 = Random.nextInt(from = 1, until = 13)
        val tvFactor1 = findViewById<TextView>(R.id.factor1)
        val tvFactor2 = findViewById<TextView>(R.id.factor2)

        tvFactor1.text = factor1.toString()
        tvFactor2.text = factor2.toString()

        val multiply = findViewById<Button>(R.id.multiply)
        multiply.setOnClickListener {
//            findViewById<TextView>(R.id.result).text = (factor1 * factor2).toString()
            val i = Intent(this, ResultActivity::class.java).apply {
//                putExtra("factor1", factor1)
//                putExtra("factor2", factor2)
                putExtra("result", Result(factor1 * factor2))
            }
//            i.putExtra("result", factor1 * factor2)
            startActivity(i)
        }
    }
}