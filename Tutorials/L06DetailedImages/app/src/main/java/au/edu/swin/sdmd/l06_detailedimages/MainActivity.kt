package au.edu.swin.sdmd.l06_detailedimages

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import l06_detailedimages.R

class MainActivity : AppCompatActivity() {
    lateinit var station: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        station = Location(
            "Glenferrie Station", "Ada May Plante", -37.821539f, 145.036473f
        )

        val vStation = findViewById<TextView>(R.id.station)
        vStation.setOnClickListener {
            // todo: create Intent
            val intent = Intent(this, DetailActivity::class.java)

            // pass data to the target activity
            /* version 1.0: pass primitive values
            intent.apply {
                putExtra("name", station.name)
                putExtra("author", station.author)
            }
             */

            /* version 2.0: pass Parcelizable object */
            intent.apply {
                putExtra("location", station)
            }

            // show the detail-activity view
//            startActivity(intent)
            startForResult.launch(intent)
        }
    }

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            Log.i("RESULT", "returned ${it.data.toString()}")
            when (result.resultCode) {
                RESULT_OK -> {
                    val data = result.data
                    val visited = data?.getParcelableExtra<Location>("visited")
                    val vStation = findViewById<TextView>(R.id.station)
                    visited?.let {
                        vStation.setTextColor(if (it.visited) Color.GREEN else Color.RED)
                        station = visited
                    }
                }
            }
        }
}