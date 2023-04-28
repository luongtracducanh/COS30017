package au.edu.swin.sdmd.l05_detailedimages

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        location = intent.getParcelableExtra<Location>("location")

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