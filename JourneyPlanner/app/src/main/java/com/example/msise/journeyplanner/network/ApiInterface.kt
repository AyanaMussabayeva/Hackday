package com.example.msise.journeyplanner.network

import com.example.msise.journeyplanner.model.Hotel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("hotels/")
    fun getHotels(): Call<List<Hotel>>

    @GET("hotels/{price}")
    fun getHotelsByPrice(@Path("price") price: Double ) : Call<List<Hotel>>

    @GET("hotels/{price}/{countryName}")
    fun getHotelsByPriceAndCountry(@Path("price") price: Double, @Path("countryName") countryName: String ) : Call<List<Hotel>>

    @GET("hotels/{price}/{countryName}/{cityName}")
    fun getHotelsByPriceCountryCity(@Path("price") price: Double, @Path("countryName") countryName: String, @Path("city") cityName: String ) : Call<List<Hotel>>
}