package co.com.meli.mobile.pruebameli.ui.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.com.meli.mobile.pruebameli.R
import co.com.meli.mobile.pruebameli.api.models.Catergory
import co.com.meli.mobile.pruebameli.api.models.Contry
import co.com.meli.mobile.pruebameli.ui.ListViewHolder

class ListCategoryAdapter  internal  constructor(
    val items: ArrayList<Catergory>,
    val context: Context?,
    val function: (Catergory, Int) -> Unit,
   // val functionContry: (Contry, Int) -> Unit
): RecyclerView.Adapter<ViewHolder>()  {

    override fun getItemCount(): Int {
        return items.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_category, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name

        holder.Detail.setOnClickListener {

            function(items[position],position)
        }

    }


}

class  ViewHolder(view: View):RecyclerView.ViewHolder(view){

    val name = view.findViewById<TextView>(R.id.textViewNameCategory)
    val Detail = view.findViewById<Button>(R.id.Button_detail)


}