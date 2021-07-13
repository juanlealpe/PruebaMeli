package co.com.meli.mobile.pruebameli.ui.Detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.com.meli.mobile.pruebameli.R
import co.com.meli.mobile.pruebameli.api.models.Search
import co.com.meli.mobile.pruebameli.api.models.results
import co.com.meli.mobile.pruebameli.ui.Detail.ViewHolder
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.*

class ListDetailProductAdapter  internal  constructor(
    val item: MutableList <results>,
    val context: Context?,
    val function: (Search, Int) -> Unit
): RecyclerView.Adapter<ViewHolder>()  {

    override fun getItemCount(): Int {
        return item.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_detail_product, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = item[position]
        holder.Title.text = item.title
        holder.Price.text =  NumberFormat.getNumberInstance(Locale.US).format( item.price)
        holder.Quantity.text = item.available_quantity.toString()


        Picasso.get()
            .load(item.thumbnail)
            .into(holder?.ImagenProduct)

    }





}


class  ViewHolder(view: View):RecyclerView.ViewHolder(view){

    val Title = view.findViewById<TextView>(R.id.textViewNameDetail)
    val ImagenProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
    val Price = view.findViewById<TextView>(R.id.textViewPrice)
    val Quantity = view.findViewById<TextView>(R.id.textViewAvailable_quantity)


}