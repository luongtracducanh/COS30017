package au.edu.swin.sdmd.l04_moreimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources

/**
 * Basic version without persistence but has Logging
 * Used to demonstrate logging and debugging.
 * */
class MainActivityBasic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // must have this statement at the start!!
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageView)

        val station = findViewById<Button>(R.id.station)
        station.setOnClickListener {
            image.setImageDrawable(
                AppCompatResources.getDrawable(applicationContext, R.drawable.station))
            image.contentDescription = "station"
        }

        val onClickTheatre = View.OnClickListener {
            image.setImageDrawable(
                AppCompatResources.getDrawable(applicationContext, R.drawable.theatre))
            image.contentDescription = "theatre"
        }

        val theatre = findViewById<Button>(R.id.theatre)
        theatre.setOnClickListener(onClickTheatre)

        Log.i(TAG, "onCreate")
    }

    fun onClickCollege(v: View) {
        val image = findViewById<ImageView>(R.id.imageView)
        image.setImageDrawable(
            AppCompatResources.getDrawable(applicationContext, R.drawable.college))
        image.contentDescription = "college"
    }

    /* Other life-cyle methods: for TESTING only */
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

/*    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
    }*/

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}