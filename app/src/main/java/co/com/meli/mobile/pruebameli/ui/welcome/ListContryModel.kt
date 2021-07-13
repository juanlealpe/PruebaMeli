package co.com.meli.mobile.pruebameli.ui.welcome

import co.com.meli.mobile.pruebameli.api.API
import co.com.meli.mobile.pruebameli.api.RetrofitClient
import co.com.meli.mobile.pruebameli.api.models.Contry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListContryModel(presenter: ListContryPresenter) : IteratorContry {


    var preseter: IListContry = presenter


    override fun ListContry() {
        val UserApiService: API = RetrofitClient.instance.create(API::class.java)
        val result: Call<List<Contry>> = UserApiService.contry()
        result.enqueue(object : Callback<List<Contry>> {

            override fun onFailure(call: Call<List<Contry>>, t: Throwable) {
                preseter.errorResult(t.message.toString())
            }

            override fun onResponse(call: Call<List<Contry>>,
                                    response: Response<List<Contry>>
            ) {
                response.body()?.let { preseter.showResult(it) }
            }

        })
    }


}



