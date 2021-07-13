package co.com.meli.mobile.pruebameli.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Contry (
    @SerializedName("default_currency_id")
    val default_currency_id: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String

    ): Parcelable