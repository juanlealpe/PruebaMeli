package co.com.meli.mobile.pruebameli.ui.Detail
import co.com.meli.mobile.pruebameli.api.models.Search

interface IListDetailProduct {


    interface Model {
        fun getDetailProduct(idsite: String,idcategory:String)

    }


    interface View {

        fun responseDetailProduct(response: Search)
        fun error(error: String?)
        fun showProgress()
        fun hideProgress()

    }

    interface Presenter {
        fun requestDetailProduct(response: Search)
        fun responseDetailProduct(idsite: String,idcategory:String)
        fun error(error: Throwable)


    }


}