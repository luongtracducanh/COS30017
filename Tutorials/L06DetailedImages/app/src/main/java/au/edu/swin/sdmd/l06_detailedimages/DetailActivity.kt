package au.edu.swin.sdmd.l06_detailedimages

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import l06_detailedimages.R

class DetailActivity : AppCompatActivity() {
    private var location: Location? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // process the data passed in
        /*version 1.0: pass primitive values
        val vName = findViewById<TextView>(R.id.name)
        val name = intent.getStringExtra("name")
        vName.text = name

        val vAuthor = findViewById<TextView>(R.id.author)
        val author = intent.getStringExtra("author")
        vAuthor.text = author
        */

        /**
         * version 2.0: pass Parcelizable object
         */
        location = intent.getParcelableExtra("location")

        location?.let {
            val vName = findViewById<TextView>(R.id.name)
            vName.text = it.name

            val vAuthor = findViewById<TextView>(R.id.author)
            vAuthor.text = it.author

            val vVisited = findViewById<Switch>(R.id.visited)
            vVisited.isChecked = it.visited
        }
    }

    override fun onBackPressed() {
        location?.visited = findViewById<Switch>(R.id.visited).isChecked
        val i = intent.apply {
            putExtra("visited", location)
        }
        setResult(Activity.RESULT_OK, i)
        super.onBackPressed()
    }
}