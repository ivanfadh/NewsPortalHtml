package com.example.newsportal.view.newslist

import com.example.newsportal.model.ArticlesItem
import com.example.newsportal.model.ArticlesResponse
import com.example.newsportal.network.ApiClient
import com.example.newsportal.network.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsMVPModel : NewsMVPContract.Model {

    lateinit var apiInterface: ApiInterface

    override fun getNewsList(onFinishedListener: NewsMVPContract.Model.OnFinishedListener, pageNo: Int) {
        apiInterface = ApiClient.client?.create(ApiInterface::class.java)!!

        val articlesResponseCall = apiInterface.news
        articlesResponseCall.enqueue(object : Callback<ArticlesResponse> {
            override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                val articlesItems = response.body()?.articles
                articlesItems?.let { onFinishedListener.onFinished(it) }
                //                view.showLoading(false);
                //                view.setNews(articlesItems);
            }

            override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                t.message?.let { onFinishedListener.onFailure(it) }
                //onFinishedListener.onFailure(t.message)

            }
        })

    }
}
