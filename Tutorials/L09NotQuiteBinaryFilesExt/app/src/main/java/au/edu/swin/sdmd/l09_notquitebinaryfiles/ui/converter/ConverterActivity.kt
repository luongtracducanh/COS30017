package au.edu.swin.sdmd.l09_notquitebinaryfiles.ui.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import au.edu.swin.sdmd.l09_notquitebinaryfiles.R
import au.edu.swin.sdmd.l09_notquitebinaryfiles.data.HistoryFile
import au.edu.swin.sdmd.l09_notquitebinaryfiles.data.SharedPrefFile

/**
 * @overview: convert decimal to binary and display the result.
 * Also record the conversion into a history file.
 */
class ConverterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_converter)

    val bConvert: Button = findViewById(R.id.bConvert_basic)
    bConvert.setOnClickListener {
      val etDecimal: EditText = findViewById(R.id.etDecimal_basic)
      val sDecimal = etDecimal.text.toString()
      if (sDecimal != "") {
        val iDecimal = sDecimal.toInt()
        val sBinary = Integer.toBinaryString(iDecimal)
        val tvResult = findViewById<TextView>(R.id.tvBinary_basic)
        tvResult.text = sBinary

        /**
         * make this the last input in the preference file.
         */
        SharedPrefFile.updateSharedPrefs(this,
          getString(R.string.preference_file_key),
          getString(R.string.last_input),
          sDecimal)

        HistoryFile.appendInput(this, HistoryFile.fileName, "$sDecimal = $sBinary")
      } else {
        val tvBinary: TextView = findViewById(R.id.tvBinary_basic)
        tvBinary.text = "No number entered"
      }
    }
  }
}