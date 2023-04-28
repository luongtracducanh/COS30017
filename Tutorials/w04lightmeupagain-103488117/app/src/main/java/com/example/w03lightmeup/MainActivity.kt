package com.example.w03lightmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel

const val KEY_IMAGE = "IMAGE"

class MainActivity : AppCompatActivity() {
    val imageViewModel: ImageViewModel by viewModels()

    var state = R.drawable.check_circle_outline_black_24dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        image.setImageDrawable(getDrawable(imageViewModel.state))

        /*savedInstanceState?.let {
            state = it.getInt(KEY_IMAGE)
            image.setImageDrawable(getDrawable(state))
        }*/

        image.setOnLongClickListener {
            imageViewModel.nextImage()
            image.setImageDrawable(getDrawable(imageViewModel.state))
            true
        }
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_IMAGE, state)
    }*/

    class ImageViewModel : ViewModel() {
        var state = R.drawable.check_circle_outline_black_24dp
        fun nextImage() {
            state = when (state) {
                R.drawable.check_circle_outline_black_24dp -> R.drawable.highlight_off_black_24dp
                R.drawable.highlight_off_black_24dp -> R.drawable.error_outline_black_24dp
                R.drawable.error_outline_black_24dp -> R.drawable.check_circle_outline_black_24dp
                else -> R.drawable.check_circle_outline_black_24dp
            }
        }
    }
}