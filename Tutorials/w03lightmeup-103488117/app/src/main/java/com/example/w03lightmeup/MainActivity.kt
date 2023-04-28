package com.example.w03lightmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    var state = R.drawable.check_circle_outline_black_24dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        image.setOnLongClickListener {
            state = when (state) {
                R.drawable.check_circle_outline_black_24dp -> R.drawable.highlight_off_black_24dp
                R.drawable.highlight_off_black_24dp -> R.drawable.check_circle_outline_black_24dp
                else -> R.drawable.check_circle_outline_black_24dp
            }
            image.setImageDrawable(getDrawable(state))
            true
        }
    }
}