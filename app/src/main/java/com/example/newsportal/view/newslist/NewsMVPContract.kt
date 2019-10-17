package com.example.newsportal.view.newslist

import android.widget.LinearLayout

import com.example.newsportal.model.ArticlesItem
import com.example.newsportal.model.ArticlesResponse

interface NewsMVPContract {

    interface Model {
        interface OnFinishedListener {
            fun onFinished(articlesItems: List<ArticlesItem>)

            fun onFailure(t: String)
        }

        fun getNewsList(onFinishedListener: OnFinishedListener, pageNo: Int)
    }

    interface View {
        fun showLoading(loading: Boolean)
        fun setNews(articlesItems: List<ArticlesItem>)
        fun onResponseFailure(reason: String)

    }

    interface Presenter {
        //callNews
        fun requestDataFromServer()
    }
}
