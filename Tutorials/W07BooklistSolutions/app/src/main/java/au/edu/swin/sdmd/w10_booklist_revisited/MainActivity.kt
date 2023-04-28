package au.edu.swin.sdmd.w10_booklist_revisited

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var list: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: BooklistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById<RecyclerView>(R.id.booklist)
        layoutManager = LinearLayoutManager(this)
        list.layoutManager = layoutManager

        // default: long book list
        longList(init = true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // create the options menu
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.short_list -> {    // short book list
                return shortList()
            }
            R.id.long_list -> { // long book list
                return longList(init = false)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun longList(init: Boolean): Boolean {
        when (init) {
            true -> {
                adapter = BooklistAdapter(BookStore.books) { book ->
                    showDetail(book)
                }
                list.adapter = adapter
            }
            else -> {
                adapter?.apply {
                    data = BookStore.books
                    notifyDataSetChanged()
                }
            }
        }

        return true
    }

    private fun shortList(): Boolean {
        //requires: adapter has been set
        adapter?.apply {
            data = BookStore.booksShort
            notifyDataSetChanged()
            return true
        }

        return false
    }

    fun showDetail(book: Book) {
        Toast.makeText(this,"Selected: "
            + book.title, Toast.LENGTH_SHORT).show()
    }
}