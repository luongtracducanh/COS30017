package au.edu.swin.sdmd.core3_local

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val saveClick = findViewById<TextView>(R.id.saveClick)
        // shared preferences
        val sharedPref = this.getSharedPreferences("saveLastClick", Context.MODE_PRIVATE)
        val temp = sharedPref.getString("saveClick", "You have not yet clicked any country").toString()

        saveClick.text = temp
    }
}