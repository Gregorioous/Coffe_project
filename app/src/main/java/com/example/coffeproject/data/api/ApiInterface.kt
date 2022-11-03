package com.example.coffeproject.data.api

import com.example.coffeproject.data.models.CoffeeApiModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("loadCoffe.php")
    fun loadCoffeeApi(): Call<ArrayList<CoffeeApiModel>>

    @FormUrlEncoded
    @POST("insert.php")
    fun insert(
        @Field("name") name: String?,
        @Field("phone") phone: String?,
        @Field("description") description: String?,
        @Field("priceOrder") priceOrder: String?,
    ): Call<ResponseBody?>?

}