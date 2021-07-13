package co.com.meli.mobile.pruebameli.api.models

import android.os.Parcelable
import co.com.meli.mobile.pruebameli.ui.category.IListCategory
import co.com.meli.mobile.pruebameli.ui.category.ListCategoryPresenter
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Catergory(

    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    val name: String

): Parcelable