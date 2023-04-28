package au.edu.swin.sdmd.core2_local

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Matcher
import java.util.regex.Pattern


class DetailActivity : AppCompatActivity() {
    private var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailName = findViewById<EditText>(R.id.detail_name)
        /*detailName.doAfterTextChanged {
            detailName?.error = if (detailName.text.toString().isNotEmpty()) null else "Name cannot be empty"
        }*/

        val detailLocation = findViewById<EditText>(R.id.detail_location)
        /*detailLocation.doAfterTextChanged {
            detailLocation?.error = if (detailLocation.text.toString().isNotEmpty()) null else "Location cannot be empty"
        }*/

        val detailDate = findViewById<EditText>(R.id.detail_date)
        /*detailDate.doAfterTextChanged {
            val regEx = "^(0[1-9]|[12]\\d|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d{2}$"
            val matcherObj: Matcher = Pattern.compile(regEx).matcher(detailDate.text)
            detailDate?.error = if (matcherObj.matches()) null else "Date have to be in the right format: dd-mm-yyyy"
        }*/

        val detailRating = findViewById<RatingBar>(R.id.ratingBar)

        location = intent.getParcelableExtra("image")
        location?.let {
            val detailImage = findViewById<ImageView>(R.id.detail_image)
            detailImage.setImageDrawable(getDrawable(it.image))
            detailLocation.setText(it.location)
            detailName.setText(it.name)
            detailDate.setText(it.date)
            detailRating.rating = it.rating
        }
    }

    override fun onBackPressed() {
        val detailName = findViewById<EditText>(R.id.detail_name)
        val detailLocation = findViewById<EditText>(R.id.detail_location)
        val detailDate = findViewById<EditText>(R.id.detail_date)
        val regEx = "^(0[1-9]|[12]\\d|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d{2}$"
        val matcherObj: Matcher = Pattern.compile(regEx).matcher(detailDate.text)

        if (detailName.text.toString().isEmpty()) detailName?.error = "Name cannot be empty"
        else if (detailLocation.text.toString().isEmpty()) detailLocation?.error =
            "Location cannot be empty"
        else if (!matcherObj.matches()) detailDate?.error =
            "Date have to be in the right format: dd-mm-yyyy"
        else {
            location?.name = detailName.text.toString()
            location?.rating = findViewById<RatingBar>(R.id.ratingBar).rating
            location?.date = detailDate.text.toString()
            location?.location = detailLocation.text.toString()

            val i = intent.apply {
                putExtra("changed", location)
            }
            setResult(Activity.RESULT_OK, i)
            super.onBackPressed()
        }
    }
}