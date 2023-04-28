package au.edu.swin.sdmd.l03_manyimages

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageView)

        val station = findViewById<Button>(R.id.station)
        /* 1st approach (easiest): in-line definition of event handler on the object */
        station.setOnClickListener {
            image.setImageDrawable(getDrawable(R.drawable.station))
        }

        /* 2nd approach: separate event handler object definition */
        val theatre = findViewById<Button>(R.id.theatre)
        val onClickTheatre = View.OnClickListener {
            image.setImageDrawable(getDrawable(R.drawable.theatre))
        }
        theatre.setOnClickListener(onClickTheatre)

        /*2nd approach (2):
        var onClickTheatre2: (() -> Unit)? = {
            image.setImageDrawable(getDrawable(R.drawable.theatre))
        }
        theatre.setOnClickListener { onClickTheatre2?.invoke() }
        */
    }

    /* 3rd: approach: invoked via button's property setting in the XML file*/
    fun onClickCollege(v: View) {
        val image = findViewById<ImageView>(R.id.imageView)
        image.setImageDrawable(getDrawable(R.drawable.college))
    }

}
