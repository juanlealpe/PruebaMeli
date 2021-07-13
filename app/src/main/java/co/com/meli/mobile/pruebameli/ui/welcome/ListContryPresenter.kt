package co.com.meli.mobile.pruebameli.ui.welcome

import co.com.meli.mobile.pruebameli.api.models.Contry
import co.com.meli.mobile.pruebameli.ui.category.CategoryActivity

class ListContryPresenter(view: WelcomeActivity) : IListContry{


    var view: WelcomeActivity? = view
    var interactor: ListContryModel = ListContryModel(this)




    override fun errorResult(t: String) {
        view?.errorResult(t)
    }

    override fun showResult(result: List<Contry>) {
        view?.showResult(result)
    }
    override fun getListContry() {
        interactor.ListContry()
    }



}