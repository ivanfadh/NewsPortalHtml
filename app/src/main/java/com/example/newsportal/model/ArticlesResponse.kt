package com.example.newsportal.model

import com.google.gson.annotations.SerializedName

class ArticlesResponse {

    @SerializedName("totalResults")
    var totalResults: Int = 0

    @SerializedName("articles")
    var articles: List<ArticlesItem>? = null

    @SerializedName("status")
    var status: String? = null

    override fun toString(): String {
        return "Response{" +
                "totalResults = '" + totalResults + '\''.toString() +
                ",articles = '" + articles + '\''.toString() +
                ",status = '" + status + '\''.toString() +
                "}"
    }
}