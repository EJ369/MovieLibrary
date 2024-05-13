package com.example.movielibrary

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClass {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}