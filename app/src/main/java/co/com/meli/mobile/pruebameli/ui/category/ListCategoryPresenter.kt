package co.com.meli.mobile.pruebameli.ui.category

import android.util.Log
import co.com.meli.mobile.pruebameli.api.models.Catergory

class ListCategoryPresenter (view: IListCategory.View) : IListCategory.Presenter {

    private val model: IListCategory.Model

    private  var view: IListCategory.View



    init {
        this.view = view
         model = ListCategoryModel(this)
    }






    override fun requestCategory(response: List<Catergory>) {
        view.hideProgress()
        view.responseCategory(response)
    }

    override fun responseCatergory(id :String) {
        try {
            view.showProgress()
            model.getCategories(id)
        } catch (ex: Exception) {
            Log.wtf("CustomerDetailPresenter", ex.message)
        }
    }


    override fun error(error: Throwable) {
        view.hideProgress()
        Log.wtf("Error Categoria", error.message)

    }

}