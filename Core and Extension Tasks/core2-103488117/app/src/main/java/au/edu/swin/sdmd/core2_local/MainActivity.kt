package au.edu.swin.sdmd.core2_local

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var university: Location
    private lateinit var station: Location
    private lateinit var hall: Location
    private lateinit var garden: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        university = Location(
            resources.getIdentifier("university", "drawable", packageName),
            "University",
            "Australia",
            "18-12-2020",
            5.00f,
            1
        )
        station = Location(
            resources.getIdentifier("station", "drawable", packageName),
            "Station",
            "Germany",
            "14-06-2015",
            4.00f,
            2
        )
        hall = Location(
            resources.getIdentifier("hall", "drawable", packageName),
            "Hall",
            "India",
            "17-09-2022",
            3.00f,
            3
        )
        garden = Location(
            resources.getIdentifier("garden", "drawable", packageName),
            "Garden",
            "France",
            "06-08-2019",
            2.00f,
            4
        )

        val universityRating = findViewById<TextView>(R.id.university_rating)
        universityRating.text = university.rating.toString()
        val stationRating = findViewById<TextView>(R.id.station_rating)
        stationRating.text = station.rating.toString()
        val hallRating = findViewById<TextView>(R.id.hall_rating)
        hallRating.text = hall.rating.toString()
        val gardenRating = findViewById<TextView>(R.id.garden_rating)
        gardenRating.text = garden.rating.toString()

        val universityName = findViewById<TextView>(R.id.university_caption)
        universityName.text = university.name
        val stationName = findViewById<TextView>(R.id.station_caption)
        stationName.text = station.name
        val hallName = findViewById<TextView>(R.id.hall_caption)
        hallName.text = hall.name
        val gardenName = findViewById<TextView>(R.id.garden_caption)
        gardenName.text = garden.name

        val universityImage = findViewById<ImageView>(R.id.university)
        universityImage.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java).apply {
                putExtra("image", university)
            }
            startForResult.launch(i)
        }

        val stationImage = findViewById<ImageView>(R.id.station)
        stationImage.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java).apply {
                putExtra("image", station)
            }
            startForResult.launch(i)
        }

        val hallImage = findViewById<ImageView>(R.id.hall)
        hallImage.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java).apply {
                putExtra("image", hall)
            }
            startForResult.launch(i)
        }

        val gardenImage = findViewById<ImageView>(R.id.garden)
        gardenImage.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java).apply {
                putExtra("image", garden)
            }
            startForResult.launch(i)
        }
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                RESULT_OK -> {
                    val data = result.data
                    val changed = data?.getParcelableExtra<Location>("changed")

                    val uniName = findViewById<TextView>(R.id.university_caption)
                    val uniRating = findViewById<TextView>(R.id.university_rating)

                    val stationName = findViewById<TextView>(R.id.station_caption)
                    val stationRating = findViewById<TextView>(R.id.station_rating)

                    val hallName = findViewById<TextView>(R.id.hall_caption)
                    val hallRating = findViewById<TextView>(R.id.hall_rating)

                    val gardenName = findViewById<TextView>(R.id.garden_caption)
                    val gardenRating = findViewById<TextView>(R.id.garden_rating)

                    changed?.let {
                        when (it.id) {
                            1 -> {
                                uniName.text = it.name
                                uniRating.text = it.rating.toString()
                                university = changed
                            }
                            2 -> {
                                stationName.text = it.name
                                stationRating.text = it.rating.toString()
                                station = changed
                            }
                            3 -> {
                                hallName.text = it.name
                                hallRating.text = it.rating.toString()
                                hall = changed
                            }
                            4 -> {
                                gardenName.text = it.name
                                gardenRating.text = it.rating.toString()
                                garden = changed
                            }
                        }
                    }

                    Snackbar.make(
                        window.decorView.rootView, "${changed?.name} updated", Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
}