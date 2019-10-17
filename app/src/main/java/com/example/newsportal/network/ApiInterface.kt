package com.example.newsportal.network

import com.example.newsportal.model.ArticlesResponse

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @get:GET("v2/top-headlines/?country=id&apiKey=f702444a43234cdd90a4521f712aec88")
    val news: Call<ArticlesResponse>

}
