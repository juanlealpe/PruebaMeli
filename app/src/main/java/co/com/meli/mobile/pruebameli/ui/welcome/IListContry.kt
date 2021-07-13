package co.com.meli.mobile.pruebameli.ui.welcome

import co.com.meli.mobile.pruebameli.api.models.Contry

interface IListContry {


        fun errorResult(t: String)
        fun showResult(result: List<Contry>)
        fun getListContry()


}