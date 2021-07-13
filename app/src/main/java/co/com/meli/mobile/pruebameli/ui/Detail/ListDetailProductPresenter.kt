package co.com.meli.mobile.pruebameli.ui.Detail

import android.util.Log
import co.com.meli.mobile.pruebameli.api.models.Catergory
import co.com.meli.mobile.pruebameli.api.models.Search
import co.com.meli.mobile.pruebameli.ui.category.IListCategory
import co.com.meli.mobile.pruebameli.ui.category.ListCategoryModel

class ListDetailProductPresenter (view: IListDetailProduct.View) : IListDetailProduct.Presenter  {

    private val model: IListDetailProduct.Model

    private  var view: IListDetailProduct.View



    init {
        this.view = view
        model = ListDetailProductModel(this)
    }




    override fun requestDetailProduct(response: Search) {
        view.hideProgress()
        view.responseDetailProduct(response)
    }

    override fun responseDetailProduct(idsite: String,idcategory:String) {

        try {
            view.showProgress()
            model.getDetailProduct(idsite,idcategory)
        } catch (ex: Exception) {
            Log.wtf("CustomerDetailPresenter", ex.message)
        }
    }

    override fun error(error: Throwable) {
        view.hideProgress()
        Log.wtf("Error Detalle Productos", error.message)
    }
}