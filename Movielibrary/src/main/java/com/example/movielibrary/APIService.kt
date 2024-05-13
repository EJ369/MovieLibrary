package com.example.movielibrary

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getData(@Query("language") language: String = "en-US", @Query("page") page: Int=1, @Header("accept") accept: String = "application/json", @Header("Authorization") authorization: String): Call<APIResponse>
}