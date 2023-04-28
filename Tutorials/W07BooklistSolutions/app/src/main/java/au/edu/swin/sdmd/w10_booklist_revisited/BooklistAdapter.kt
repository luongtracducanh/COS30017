package au.edu.swin.sdmd.w10_booklist_revisited

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BooklistAdapter(var data: List<Book>,
                      private val listener: (Book) -> Unit): RecyclerView.Adapter<BooklistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.book_layout, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        val image = v.findViewById<ImageView>(R.id.cover)
        val title = v.findViewById<TextView>(R.id.title)
        val rating = v.findViewById<RatingBar>(R.id.rating)

        fun bind(item: Book) {
            title.text = item.title
            rating.rating = item.rating
            val imageRes = v.context.resources.getIdentifier("l${item.image}" ,
                "drawable", v.context.packageName)
            image.setImageResource(imageRes)

            v.setOnClickListener { listener(item) }
        }
    }
}