package au.edu.swin.sdmd.core3_local

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedalListAdapter(
    private var data: List<Medal>,
    private val stringTotalList: String,
    private val listener: (Medal) -> Unit
) : RecyclerView.Adapter<MedalListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.medal_layout, parent, false) as View
        return ViewHolder(view, stringTotalList)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val v: View, private val stringTotalList: String) :
        RecyclerView.ViewHolder(v) {
        private val countryName = v.findViewById<TextView>(R.id.country_name)
        private val countryCode = v.findViewById<TextView>(R.id.country_code)
        private val totalMedal = v.findViewById<TextView>(R.id.totalMedals)

        fun bind(item: Medal) {
            countryName.text = item.country
            countryCode.text = item.countryCode
            totalMedal.text = item.totalMedals.toString()

            val totalList = stringTotalList.split(",").map { it.trim() }
            Log.i("TOP10", "$totalList")

            if (totalList.contains(totalMedal.text)) v.setBackgroundColor(Color.GRAY)
            else v.setBackgroundColor(Color.WHITE)

            v.setOnClickListener {
                listener(item)
            }
        }
    }
}