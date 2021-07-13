package co.com.meli.mobile.pruebameli.ui.Detail

import co.com.meli.mobile.pruebameli.api.API
import co.com.meli.mobile.pruebameli.api.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import co.com.meli.mobile.pruebameli.api.models.Search



class ListDetailProductModel (presenter: IListDetailProduct.Presenter) : IListDetailProduct.Model {

    private val presenter: IListDetailProduct.Presenter


    private val api: API
    private var composite: CompositeDisposable



    init {
        this.presenter = presenter
        val retrofit = RetrofitClient.instance
        api = retrofit.create(API::class.java)
        composite = CompositeDisposable()
    }




    override fun getDetailProduct(idsite: String,idcategory:String) {

        composite.add(api.search(idsite,idcategory)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> presenter.requestDetailProduct(result)},
                { error -> presenter.error(error)}))


        /*val UserApiService: API = RetrofitClient.instance.create(API::class.java)
        val result: Call<List<Search>> = UserApiService.search(idsite,idcategoy)
        result.enqueue(object : Callback<List<Search>> {

            override fun onFailure(call: Call<List<Search>>, error: Throwable) {
                presenter.error(error)
            }

            override fun onResponse(call: Call<List<Search>>,
                                    response: Response<List<Search>>
            ) {
                response.body()?.let { presenter.requestDetailProduct(it) }
            }

        }) */
    }
}