package co.com.meli.mobile.pruebameli.ui.category

import android.app.Dialog
import android.content.Context
import android.content.Intent
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
import co.com.meli.mobile.pruebameli.ui.Detail.DetailActivity
import co.com.meli.mobile.pruebameli.ui.utils.Constants
import co.com.meli.mobile.pruebameli.ui.utils.UtilsProgress
import co.com.meli.mobile.pruebameli.ui.welcome.IListContry

class CategoryActivity : AppCompatActivity() ,IListCategory.View {

    private lateinit var  search: SearchView
    private lateinit var  recyclerviewCategory :RecyclerView
    private lateinit var adapter: ListCategoryAdapter
    private var ListCategory:ArrayList<Catergory> = arrayListOf()
    private lateinit var presenterCategory: IListCategory.Presenter
    private lateinit var contry: Contry
    private lateinit var dialogProgress: Dialog




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        dialogProgress = UtilsProgress.dialogProgressDialog(this)


        if (intent.hasExtra(Constants.CONST_DETAIL)) {

            contry = intent.getParcelableExtra(Constants.CONST_DETAIL)!!

            search = findViewById(R.id.search)
            recyclerviewCategory = findViewById(R.id.recyclerviewCategory)


            presenterCategory = ListCategoryPresenter(this@CategoryActivity)

            presenterCategory.responseCatergory((contry.id))

            recyclerviewCategory.layoutManager = LinearLayoutManager(this@CategoryActivity)
            recyclerviewCategory.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = ListCategoryAdapter(ListCategory, this) { itemDto: Catergory, position: Int ->
                evenOnClickCheck(itemDto, position,this,contry )

            }
            recyclerviewCategory.adapter = adapter



        }
    }




    override fun responseCategory(response: List<Catergory>) {
        ListCategory.clear()
        ListCategory.addAll(response)
        adapter.notifyDataSetChanged()
        dialogProgress.dismiss()



    }


    override fun error(error: String?) {
        Toast.makeText(this,"Error Reponse", Toast.LENGTH_LONG).show()
        print("error"+error)
        dialogProgress.dismiss()
    }

    override fun showProgress() {

        try {

            dialogProgress.show()

        } catch (ex: WindowManager.BadTokenException) {

        }
    }

    override fun hideProgress() {
        if (dialogProgress.isShowing) {
            dialogProgress.dismiss()
        }
    }


    private fun evenOnClickCheck(catergory: Catergory, position: Int,context: Context,contry: Contry) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(Constants.CONST_CATEGORY,catergory)
        intent.putExtra(Constants.CONST_DETAIL,contry)

        context?.startActivity(intent)
        Log.e("CategoryActivity", "Detalle de categoria ${catergory.id}at position $position")
        Log.e("ContryActivity", "Contry ${contry.id}at position $position")

    }
}