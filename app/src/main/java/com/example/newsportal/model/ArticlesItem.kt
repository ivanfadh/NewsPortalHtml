package com.example.newsportal.model

import com.google.gson.annotations.SerializedName

class ArticlesItem {

    @SerializedName("publishedAt")
    var publishedAt: String? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("urlToImage")
    var urlToImage: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("source")
    var source: Source? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("content")
    var content: String? = null

    override fun toString(): String {
        return "ArticlesItem{" +
                "publishedAt = '" + publishedAt + '\''.toString() +
                ",author = '" + author + '\''.toString() +
                ",urlToImage = '" + urlToImage + '\''.toString() +
                ",description = '" + description + '\''.toString() +
                ",source = '" + source + '\''.toString() +
                ",title = '" + title + '\''.toString() +
                ",url = '" + url + '\''.toString() +
                ",content = '" + content + '\''.toString() +
                "}"
    }
}