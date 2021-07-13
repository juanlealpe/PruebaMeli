package co.com.meli.mobile.pruebameli.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.com.meli.mobile.pruebameli.R
import co.com.meli.mobile.pruebameli.api.models.Contry
import co.com.meli.mobile.pruebameli.ui.category.CategoryActivity
import co.com.meli.mobile.pruebameli.ui.utils.Constants

class ListContryAdapter internal  constructor(
    val items: ArrayList<Contry>,
    val context: Context?,
   val function: (Contry, Int) -> Unit

): RecyclerView.Adapter<ListViewHolder>() {



    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_contry, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textViewContry.text = items[position].name

        holder.itemView.setOnClickListener {

            function(items[position],position)
        }

    }





}
class  ListViewHolder(view: View):RecyclerView.ViewHolder(view){

    val textViewContry = view.findViewById<TextView>(R.id.textViewContry)

}

