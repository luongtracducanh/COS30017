package au.edu.swin.sdmd.w07_numberlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showList(100)

    }

    fun showList(numItems: Int) {
        val numberList = findViewById<RecyclerView>(R.id.numberList)

        val data = IntArray(numItems) { it }.filter { it % 3 == 0 || it % 5 == 0}
        val adapter = NumberAdapter(data) { showDetail(it) }
        numberList.layoutManager = LinearLayoutManager(this)
        numberList.adapter = adapter
    }

    fun showDetail(item: Int) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("NUMBER", item)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.numitems, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.long_list -> {
                showList(500)
                true
            }
            R.id.short_list -> {
                showList(50)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}