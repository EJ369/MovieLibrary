package com.example.movielibrary

import android.util.Log
import retrofit2.Call

object FetchData {
    private val apiService = NetworkClass.apiService

    fun getMovies(key: String, category: String, onSuccess: (List<Movie>) -> Unit, onFailure: (String) -> Unit) {
        val call: Call<APIResponse> = apiService.getData(category, authorization = "Bearer $key")

        call.enqueue(object : retrofit2.Callback<APIResponse> {
            override fun onResponse(call: Call<APIResponse>, response: retrofit2.Response<APIResponse>) {
                if (response.isSuccessful) {
                    val apiResponse: APIResponse? = response.body()
                    apiResponse?.let {
                        onSuccess(it.results)
                    } ?: onFailure("Empty Response")
                } else {
                    onFailure("API request failed with code ${response.code()}")
                }
            }

            override fun onFailure(p0: Call<APIResponse>, p1: Throwable) {
                Log.e("FetchData", "onFailure: ${p1.message}")
            }
        })
    }
}