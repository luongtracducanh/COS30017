package com.example.cardoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c = Card("ACE", "HEARTS")

        val flip = findViewById<Button>(R.id.flip)

        val card = findViewById<TextView>(R.id.face_up)
        card.text = c.printDetails()

        val onClickFlip = View.OnClickListener {
            card.text = c.printDetails()
            c.flip()
            card.text = c.printDetails()
        }
        flip.setOnClickListener(onClickFlip)
    }
}