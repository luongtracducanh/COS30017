package au.edu.swin.sdmd.l04_moreimages

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

const val TAG2: String = "MA-ViewModel/LC"

/* Using ViewModel to save state */
class MainActivityViewModel : AppCompatActivity() {
    // This needs to be a class variable
    /* original code:
        private val viewModel: ImageModel by viewModels()
     */

    /* lazily initialise viewModel as part of onCreateView(): from android-dev-guide
    private lateinit var viewModel: ImageModel
    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        val v: View? = super.onCreateView(parent, name, context, attrs)

        Log.i("LC/MainActivityViewModel", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(ImageModel::class.java)

        return v;
    }*/

    //   another lazy initialisation of viewModel (from BNR, Listing 4.8)
    private val viewModel: ImageModel by lazy {
        ViewModelProvider(this).get(ImageModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Don't forget to update the UI with the current image!
        updateImage()

        val station = findViewById<Button>(R.id.station)
        station.setOnClickListener {
            // Update click listeners to use view model data
            viewModel.image = "station"
            updateImage()
        }

        val college = findViewById<Button>(R.id.college)
        college.setOnClickListener {
            viewModel.image = "college"
            updateImage()
        }

        val onClickTheatre = View.OnClickListener {
            viewModel.image = "theatre"
            updateImage()
        }

        val theatre = findViewById<Button>(R.id.theatre)
        theatre.setOnClickListener(onClickTheatre)

    }

    private fun updateImage() {
        val image = findViewById<ImageView>(R.id.imageView)
        image.setImageDrawable(AppCompatResources.getDrawable( applicationContext,viewModel.getCurrentImage))
        image.contentDescription = viewModel.image
    }

    /* Other life-cyle methods: for TESTING only */
    override fun onStart() {
        super.onStart()
        Log.i(TAG2, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG2, "onRestart")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG2, "onRestoreInstanceState")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG2, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG2, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG2, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG2, "onDestroy")
    }
}

/**
 * The view model itself: now contains the images
 */
class ImageModel: ViewModel() {
    var image: String = "station"

    init {
        // an init block to see how ViewModel is lifecycle-aware
        Log.i("LC/ImageModel", "Created")
    }

    val getCurrentImage: Int
        get() = when(image) {
            "station" -> R.drawable.station
            "college" -> R.drawable.college
            "theatre" -> R.drawable.theatre
            else -> R.drawable.station
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("LC/ImageModel", "ImageModel destroyed!")
    }
}