package au.edu.swin.sdmd.l09_notquitebinaryfiles.ui.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import au.edu.swin.sdmd.l09_notquitebinaryfiles.R
import au.edu.swin.sdmd.l09_notquitebinaryfiles.data.HistoryFile
import au.edu.swin.sdmd.l09_notquitebinaryfiles.data.SharedPrefFile

class HistoryActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_history)

    /**
     * check if something is stored in the shared preferences file to show,
     * and update the TextView on screen.
     */
    val sHistory: String? = SharedPrefFile.checkSharedPrefs(this,
      getString(R.string.preference_file_key),
      getString(R.string.last_input),
      getString(R.string.last_input_defval)
    )
    sHistory?.let {
      val tvHistory: TextView = findViewById(R.id.history_basic)
      tvHistory.text = String.format("Last value converted was %s", it)
    }

    /**
     * The detailed retrieval of data from the file has moved to another
     * class; this gets a list of the strings in the file and provides them
     * to the list adapter. This is just using the old style list widget for
     * simplicity.
     */
    this.let { cxt ->
      val numbers = HistoryFile.getFileContents(cxt, HistoryFile.fileName)
      val lvNumbers: ListView = findViewById(R.id.history_list_basic)
      lvNumbers.adapter = ArrayAdapter<Any?>(
        cxt,
        android.R.layout.simple_list_item_1, numbers
      )
    }
  }
}