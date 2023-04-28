package au.edu.swin.sdmd.myapp

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var currentScore: Int = 0

    override fun onStart() {
        super.onStart()
        Log.i("LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFECYCLE", "onRestart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("LIFECYCLE", "onCreate")

        val score = findViewById<TextView>(R.id.score)
        val increase = findViewById<Button>(R.id.increase)
        val decrease = findViewById<Button>(R.id.decrease)
        val reset = findViewById<Button>(R.id.reset)

        val mediaPlayer = MediaPlayer.create(this, R.raw.alarm_clock)

        fun setScoreColor() {
            if (currentScore in 5..9)
//            score.setTextColor(Color.parseColor("#0000FF"))
                score.setTextColor(
                    ContextCompat.getColor(
                        applicationContext, R.color.blue
                    )
                )
            else if (currentScore >= 10)
//            score.setTextColor(Color.parseColor("#00FF00"))
                score.setTextColor(
                    ContextCompat.getColor(
                        applicationContext, R.color.green
                    )
                )
            else
//            score.setTextColor(Color.parseColor("#000000"))
                score.setTextColor(
                    ContextCompat.getColor(
                        applicationContext, R.color.black
                    )
                )
        }

        savedInstanceState?.let {
            currentScore = savedInstanceState.getInt("ANSWER")
            score.text = currentScore.toString()
            setScoreColor()
        }

        increase.setOnClickListener {
            currentScore = increase(score.text.toString())
            score.text = currentScore.toString()
            setScoreColor()
            if (currentScore == 15) {
                mediaPlayer.start()
            }
        }
        decrease.setOnClickListener {
            currentScore = decrease(score.text.toString())
            score.text = currentScore.toString()
            setScoreColor()
        }
        reset.setOnClickListener {
            currentScore = reset(score.text.toString())
            score.text = currentScore.toString()
            setScoreColor()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ANSWER", currentScore)
        Log.i("LIFECYCLE", "saveInstanceState $currentScore")
    }

    private fun increase(score: String): Int {
        return if (score.toInt() < 15) score.toInt() + 1
        else score.toInt()
    }

    private fun decrease(score: String): Int {
        return if (score.toInt() > 0) score.toInt() - 1
        else score.toInt()
    }

    private fun reset(score: String) = score.toInt() - score.toInt()
}