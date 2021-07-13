package co.com.meli.mobile.pruebameli.ui.welcome

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.com.meli.mobile.pruebameli.R
import co.com.meli.mobile.pruebameli.api.models.Catergory
import co.com.meli.mobile.pruebameli.api.models.Contry
import co.com.meli.mobile.pruebameli.ui.ListContryAdapter
import co.com.meli.mobile.pruebameli.ui.category.CategoryActivity
import co.com.meli.mobile.pruebameli.ui.utils.Constants
import co.com.meli.mobile.pruebameli.ui.utils.UtilsProgress

class WelcomeActivity : AppCompatActivity(),IListContry {


    var presenter:ListContryPresenter = ListContryPresenter(this)
    private var ListContry:ArrayList<Contry> = arrayListOf()
    private lateinit var adapterContry:ListContryAdapter
    private lateinit var dialogProgress: Dialog
    private lateinit var detailCatergory: Catergory


    private lateinit var recyclerviewContry:RecyclerView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerviewContry = findViewById(R.id.recyclerviewContry)
        dialogProgress = UtilsProgress.dialogProgressDialog(this)

        //detailCatergory = intent.getParcelableExtra(Constants.CONST_DETAIL)!!

            recyclerviewContry.layoutManager = LinearLayoutManager(this@WelcomeActivity)
            recyclerviewContry.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapterContry = ListContryAdapter(ListContry, this) { itemDto: Contry, position: Int ->
                evenOnClickCheck(itemDto, position,this )

            }
            recyclerviewContry.adapter = adapterContry

            callService()

    }

    private fun callService(){
        dialogProgress.show()
        presenter.getListContry()




    }


    override fun getListContry() {

    }


    override fun showResult(result: List<Contry>) {
        ListContry.clear()
        ListContry.addAll(result)
        adapterContry.notifyDataSetChanged()
        dialogProgress.dismiss()


    }



    override fun errorResult(t: String) {
        Toast.makeText(this,"Verifique conexion a internet", Toast.LENGTH_LONG).show()
        print("Error paises"+t)
        dialogProgress.dismiss()
    }


    private fun evenOnClickCheck(contry: Contry, position: Int,context:Context) {

        val intent = Intent(context, CategoryActivity::class.java)
        intent.putExtra(Constants.CONST_DETAIL,contry)
        context?.startActivity(intent)

        Log.e("MainActivity","Lista de usuariod ${contry.id}at position $position")



    }

}