package au.edu.swin.sdmd.w07_numberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val number = intent.getIntExtra("NUMBER", 0)
        val tvFact = findViewById<TextView>(R.id.fact)
        tvFact.text = if (number % 2 == 0) "$number is even" else "$number is odd"
    }
}