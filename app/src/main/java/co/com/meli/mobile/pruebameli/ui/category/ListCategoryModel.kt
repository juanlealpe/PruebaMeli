package co.com.meli.mobile.pruebameli.ui.category

import android.icu.util.ULocale
import co.com.meli.mobile.pruebameli.api.API
import co.com.meli.mobile.pruebameli.api.RetrofitClient
import co.com.meli.mobile.pruebameli.api.models.Catergory
import co.com.meli.mobile.pruebameli.api.models.Contry
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCategoryModel (presenter: IListCategory.Presenter) : IListCategory.Model {


    private val presenter: IListCategory.Presenter


    private val api: API
    private var composite: CompositeDisposable



    init {
        this.presenter = presenter
        val retrofit = RetrofitClient.instance
        api = retrofit.create(API::class.java)
        composite = CompositeDisposable()
    }



    override fun getCategories(id: String) {


        val UserApiService: API = RetrofitClient.instance.create(API::class.java)
        val result: Call<List<Catergory>> = UserApiService.category(id)
        result.enqueue(object : Callback<List<Catergory>> {

            override fun onFailure(call: Call<List<Catergory>>, error: Throwable) {
                presenter.error(error)
            }

            override fun onResponse(call: Call<List<Catergory>>,
                                    response: Response<List<Catergory>>
            ) {
                response.body()?.let { presenter.requestCategory(it) }
            }

        })
    }

}