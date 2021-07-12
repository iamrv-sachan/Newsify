package com.rajdroid.daggerdemo.di

import com.rajdroid.daggerdemo.model.News
import retrofit2.Response
import retrofit2.http.*

const val API_KEY="fdc8e9b04d2e418094b7644a116bc555"
interface RetroServiceInterface {
//https://newsapi.org/v2/everything?q=bollywood&apiKey=fdc8e9b04d2e418094b7644a116bc555
//    https://newsapi.org/v2/everything/users/cricket/?apikey=fdc8e9b04d2e418094b7644a116bc555
//    @GET("everything?&apiKey=$API_KEY")
//    fun getDataFromAPI(@Query("q") q: String): Call<News>?
    @Headers("x-api-key:$API_KEY")
    @GET("everything")
    suspend fun getDataFromAPI(
        @Query("q") query: String?
    ): Response<News?>
}