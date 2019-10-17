package com.example.newsportal.model

import com.google.gson.annotations.SerializedName

class Source {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: Any? = null

    override fun toString(): String {
        return "Source{" +
                "name = '" + name + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                "}"
    }
}