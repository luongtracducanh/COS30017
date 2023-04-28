package au.edu.swin.sdmd.w06_multiplessolutions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        val factor1 = intent.getIntExtra("factor1", -1)
//        val factor2 = intent.getIntExtra("factor2", -1)
        val result = intent.getParcelableExtra<Result>("result")
        val tvResult = findViewById<TextView>(R.id.result)
//        tvResult.text = (factor1 * factor2).toString()
        tvResult.text = result?.opResult.toString()
    }
}