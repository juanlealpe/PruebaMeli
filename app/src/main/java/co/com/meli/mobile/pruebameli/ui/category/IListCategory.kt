package co.com.meli.mobile.pruebameli.ui.category

import co.com.meli.mobile.pruebameli.api.models.Catergory

interface IListCategory {


    interface Model {
        fun getCategories(id: String)

    }


    interface View {

        fun responseCategory(response: List<Catergory>)
        fun error(error: String?)
        fun showProgress()
        fun hideProgress()

    }

    interface Presenter {
        fun requestCategory(response: List<Catergory>)
       fun responseCatergory(id: String)
        fun error(error: Throwable)


    }

}