package co.com.meli.mobile.pruebameli.ui.Detail

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.com.meli.mobile.pruebameli.R
import co.com.meli.mobile.pruebameli.api.models.Catergory
import co.com.meli.mobile.pruebameli.api.models.Contry
import co.com.meli.mobile.pruebameli.api.models.Search
import co.com.meli.mobile.pruebameli.api.models.results
import co.com.meli.mobile.pruebameli.ui.utils.Constants
import co.com.meli.mobile.pruebameli.ui.utils.UtilsProgress

class DetailActivity : AppCompatActivity() , IListDetailProduct.View  {


    private lateinit var category: Catergory
    private lateinit var dialogProgress: Dialog
    private lateinit var contry: Contry

    private lateinit var presenterDetailProduct: IListDetailProduct.Presenter
    private var ListDeatilProduct: MutableList<results> = arrayListOf()



    private lateinit var  searchDetail: SearchView
    private lateinit var  recyclerviewDetailProduct : RecyclerView
    private lateinit var adapter: ListDetailProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        dialogProgress = UtilsProgress.dialogProgressDialog(this)


        if (intent.hasExtra(Constants.CONST_CATEGORY)) {

            category = intent.getParcelableExtra(Constants.CONST_CATEGORY)!!
            contry = intent.getParcelableExtra(Constants.CONST_DETAIL)!!

            searchDetail = findViewById(R.id.searchDetail)
            recyclerviewDetailProduct = findViewById(R.id.recyclerviewDetailProduct)

            presenterDetailProduct = ListDetailProductPresenter(this@DetailActivity)

            presenterDetailProduct.responseDetailProduct(contry.id,category.id)

            recyclerviewDetailProduct.layoutManager = LinearLayoutManager(this@DetailActivity)

            recyclerviewDetailProduct.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )

            adapter = ListDetailProductAdapter(ListDeatilProduct,this){ itemDto: Search, position: Int ->
                Log.e("CategoryActivity", "Detalle de categoria ${itemDto.results}at position $position")

            }
            recyclerviewDetailProduct.adapter = adapter

        }



    }









    override fun responseDetailProduct(response: Search) {
        ListDeatilProduct.clear()
        Log.i("Respuesta cotizacion", response.results.toString())
        ListDeatilProduct.addAll(response.results.toList())
        adapter.notifyDataSetChanged()
        dialogProgress.dismiss()
    }

    override fun error(error: String?) {
        Toast.makeText(this,"Error Reponse", Toast.LENGTH_LONG).show()
        print("error"+error)
        dialogProgress.dismiss()    }

    override fun showProgress() {
        try {

            dialogProgress.show()

        } catch (ex: WindowManager.BadTokenException) {

        }    }

    override fun hideProgress() {
        if (dialogProgress.isShowing) {
            dialogProgress.dismiss()
        }    }
}


