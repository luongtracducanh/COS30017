package au.edu.swin.sdmd.core3_local

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var list: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: MedalListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.medallist)
        layoutManager = LinearLayoutManager(this)
        list.layoutManager = layoutManager

        val medals = mutableListOf<Medal>()
        resources.openRawResource(R.raw.medallists).bufferedReader().forEachLine {
            val temp = it.split(",")
            try {
                medals.add(
                    Medal(
                        temp[0],
                        temp[1],
                        temp[2].toInt(),
                        temp[3].toInt(),
                        temp[4].toInt(),
                        temp[5].toInt(),
                        temp[3].toInt() + temp[4].toInt() + temp[5].toInt()
                    )
                )
            } catch (_: java.lang.NumberFormatException) {
            }
        }

        medals.forEach {
            Log.i(
                "MEDALS",
                "${it.country} - ${it.countryCode} - ${it.timesCompeted} - ${it.gold} - ${it.silver} - ${it.bronze}"
            )
        }

        val totalList = mutableListOf<Int>()
        medals.forEach {
            totalList.add(it.totalMedals)
        }
        totalList.sortDescending()

        val newTotalList = mutableListOf<Int>()
        for (i in 0..9) {
            newTotalList.add(totalList[i])
        }

        val stringTotalList = newTotalList.joinToString()
        Log.i(
            "TOP10", stringTotalList
        )

        adapter = MedalListAdapter(medals, stringTotalList) { medal ->
            showDetail(medal)
            saveClick(medal)
        }
        list.adapter = adapter
    }

    private fun showDetail(medal: Medal) {
        // core requirement
        /*Toast.makeText(
            this, "${medal.country} has won ${medal.gold} gold medals", Toast.LENGTH_SHORT
        ).show()*/

        // extension requirement
        val bottomSheetFragment = BottomSheetFragment()
        val mBundle = Bundle()

        mBundle.putString("name", medal.country)
        mBundle.putString("code", medal.countryCode)
        mBundle.putInt("gold", medal.gold)
        mBundle.putInt("silver", medal.silver)
        mBundle.putInt("bronze", medal.bronze)
        bottomSheetFragment.arguments = mBundle

        bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")
    }

    private fun saveClick(medal: Medal) {
        val sharedPref = this.getSharedPreferences("saveLastClick", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(
                "saveClick",
                "The last country clicked was ${medal.country} (${medal.countryCode})."
            )
            apply()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save -> {
                Log.i("MENU", "success")
                val i = Intent(this, SaveActivity::class.java)
                startActivity(i)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}