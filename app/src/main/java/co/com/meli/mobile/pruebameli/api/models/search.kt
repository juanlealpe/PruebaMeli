package co.com.meli.mobile.pruebameli.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Search(

    @SerializedName("site_id")
    val site_id: String,
    @SerializedName("paging")
    val paging: paging,
    @SerializedName("results")
    val results: MutableList < results>
): Parcelable


    @Parcelize
    data class paging(
        @SerializedName("total")
        val total: Int,
        @SerializedName("primary_results")
        val primary_results: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("limit")
        val limit: Int,

    ): Parcelable
@Parcelize
data class results(

    @SerializedName("results")
    val results: String,
    @SerializedName("site_id")
    val site_idd: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: BigDecimal,
    @SerializedName("sale_price")
    val sale_price: String,
    @SerializedName("currency_id")
    val currency_id: String,
    @SerializedName("available_quantity")
    val available_quantity: Int,
    @SerializedName("sold_quantity")
    val sold_quantity: Int,
    @SerializedName("buying_mode")
    val buying_mode: String,
    @SerializedName("listing_type_id")
    val listing_type_id: String,
    @SerializedName("stop_time")
    val stop_time: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("thumbnail_id")
    val thumbnail_id: String,
    @SerializedName("accepts_mercadopago")
    val accepts_mercadopago: String,
    @SerializedName("address")
    val address: address,
    @SerializedName("shipping")
    val shipping: shipping,
    @SerializedName("seller_address")
    val seller_address: seller_address,



    ): Parcelable



@Parcelize
data class price(
    @SerializedName("price")
    val price: Int,
    @SerializedName("prices")
    val prices: prices,

): Parcelable

@Parcelize
data class prices(
    @SerializedName("id")
    val id: String,
    @SerializedName("prices")
    val prices: pricess,

    ): Parcelable

@Parcelize
data class pricess(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: prices,


    ): Parcelable




@Parcelize
data class address(

    @SerializedName("state_id")
    val state_id: String,
    @SerializedName("state_name")
    val state_name: String,
    @SerializedName("city_id")
    val city_id: String,
    @SerializedName("city_name")
    val city_name: String,



    ): Parcelable

@Parcelize
data class shipping(

    @SerializedName("free_shipping")
    val free_shipping: Boolean,
    @SerializedName("mode")
    val mode: String,
    @SerializedName("logistic_type")
    val logistic_type: String,
    @SerializedName("store_pick_up")
    val store_pick_up: Boolean,



    ): Parcelable


@Parcelize
data class seller_address(

    @SerializedName("id")
    val id: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("address_line")
    val address_line: String,
    @SerializedName("zip_code")
    val zip_code: Boolean,
    @SerializedName("country")
    val country: country,
    ): Parcelable

@Parcelize
data class country(

    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("state")
    val state: state,
): Parcelable

@Parcelize
data class state(

    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("city")
    val city: city,
): Parcelable

@Parcelize
data class city(

    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,

): Parcelable

