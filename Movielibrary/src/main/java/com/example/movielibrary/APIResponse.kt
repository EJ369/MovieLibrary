package com.example.movielibrary

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("results") val results: List<Movie>
)
