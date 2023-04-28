package au.edu.swin.sdmd.l09_notquitebinaryfiles.ui.process

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import au.edu.swin.sdmd.l09_notquitebinaryfiles.R
import au.edu.swin.sdmd.l09_notquitebinaryfiles.data.RawResourceFile

class ProcessActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_process)

    val text = findViewById<TextView>(R.id.text_process_basic)

    /* read a raw resource file (res/raw): binary_process.html */
    val process = RawResourceFile.readContent(resources, R.raw.binary_process)

    /* convert read content to HTML and display on text view*/
    text.text = Html.fromHtml(process, Html.FROM_HTML_MODE_COMPACT)
  }
}