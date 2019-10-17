package com.example.newsportal.view.newslist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.newsportal.R
import com.example.newsportal.model.ArticlesItem
import com.example.newsportal.adapter.NewsAdapter
import com.example.newsportal.view.texview.fromHtmlActivity
import com.example.newsportal.view.texview.fromHtmlActivityFail

class MainActivity : AppCompatActivity(), NewsMVPContract.View {
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    private val articlesItems: List<ArticlesItem>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var presenter: NewsMVPContract.Presenter
    lateinit var loadingLayout: LinearLayout
    lateinit var responseLayout: LinearLayout
    lateinit var tvResponse: TextView
    lateinit var buttonReload: Button
    lateinit var buttomHtml: Button
    lateinit var buttonHtmlFail: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        presenter = NewsMVPPresenter(this)
        loadingLayout = findViewById(R.id.layout_loading)
        responseLayout = findViewById(R.id.layout_error)
        tvResponse = findViewById(R.id.tvError)
        buttonReload = findViewById(R.id.buttonReload)
        presenter.requestDataFromServer()
        buttomHtml = findViewById(R.id.buttonHtml)
        buttonHtmlFail = findViewById(R.id.buttonHtmlFail)



        buttomHtml.setOnClickListener {
            intent = Intent(this, fromHtmlActivity::class.java)
            startActivity(intent)
        }

        buttonHtmlFail.setOnClickListener {
            intent = Intent(this, fromHtmlActivityFail::class.java)
            startActivity(intent)
        }


    }

    override fun showLoading(loading: Boolean) {
        if (loading) {
            responseLayout.visibility = View.GONE
            loadingLayout.visibility = View.VISIBLE
        } else {
            loadingLayout.visibility = View.GONE
        }

    }

    override fun setNews(articlesItems: List<ArticlesItem>) {
        adapter = NewsAdapter(this@MainActivity, articlesItems)
        recyclerView?.adapter = adapter
    }

    override fun onResponseFailure(reason: String) {
        tvResponse.text = reason
        responseLayout.visibility = View.VISIBLE
        buttonReload.setOnClickListener { presenter.requestDataFromServer() }
    }

    companion object {

        private val NEWS_ID = "id"
    }

    /*public void callNews(){
        Call<ArticlesResponse> getNewsCall = apiInterface.getNews();
        getNewsCall.enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                List<ArticlesItem> newsList = response.body().getArticles();
//                Log.d("Retrofit", "Jumlah berita : " + String.valueOf(newsList.size()));
                adapter = new NewsAdapter(MainActivity.this, newsList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
                Log.d("Retrofit", t.toString());

            }
        });
    }*/


}

