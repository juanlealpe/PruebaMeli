package co.com.meli.mobile.pruebameli.api

import co.com.meli.mobile.pruebameli.api.models.Catergory
import retrofit2.Call
import co.com.meli.mobile.pruebameli.api.models.Contry
import co.com.meli.mobile.pruebameli.api.models.Search
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    @GET("sites")
    fun contry(): Call<List<Contry>>

    @GET("sites/{id}/categories")
    fun category(@Path("id") id: String):
           // Observable<Catergory>
            Call<List<Catergory>>


    @GET("sites/{id}/search")
    fun search(@Path("id") idsite: String,
              // @Path("idCategoryy") idCategory: String,
               @Query(value = "category", encoded = true) idCategory: String = " ",

    ): //Call<List<Search>>
Observable<Search>
}