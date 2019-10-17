package com.example.newsportal.view.newslist

import com.example.newsportal.model.ArticlesItem
import com.example.newsportal.model.ArticlesResponse
import com.example.newsportal.network.ApiClient
import com.example.newsportal.network.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsMVPPresenter(private val newsMVPView: NewsMVPContract.View?) : NewsMVPContract.Presenter, NewsMVPContract.Model.OnFinishedListener {
    private val newsMVPModel: NewsMVPContract.Model

    init {
        newsMVPModel = NewsMVPModel()
    }

    /* @Override
    public void callNews() {

        view.showLoading(true);
        Call<ArticlesResponse> articlesResponseCall = apiInterface.getNews();
        articlesResponseCall.enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                List<ArticlesItem> articlesItems = response.body().getArticles();
                view.showLoading(false);
                view.setNews(articlesItems);
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
//                onFinishedListener.onFailure(t);

                view.onRequestFailure(t.getMessage());
                view.showLoading(false);

            }
        });

    }*/

    override fun requestDataFromServer() {

        newsMVPView?.showLoading(true)

        newsMVPModel.getNewsList(this, 1)
    }

    override fun onFinished(articlesItems: List<ArticlesItem>) {
        newsMVPView!!.setNews(articlesItems)
        newsMVPView.showLoading(false)


    }

    override fun onFailure(t: String) {
        newsMVPView!!.onResponseFailure(t)
        newsMVPView.showLoading(false)

    }

}
