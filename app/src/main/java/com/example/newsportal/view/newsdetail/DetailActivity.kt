package com.example.newsportal.view.newsdetail

import androidx.appcompat.app.AppCompatActivity

import android.media.Image
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView

import com.example.newsportal.R
import com.squareup.picasso.Picasso

import java.net.URL
import java.util.Scanner

class DetailActivity : AppCompatActivity() {

    internal lateinit var tvTitle: TextView
    internal lateinit var tvDate: TextView
    internal lateinit var tvPublisher: TextView
    internal lateinit var wvNews: WebView
    internal lateinit var ivNews: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ivNews = findViewById(R.id.ivNewsDetail)
        tvTitle = findViewById(R.id.tvTitleDetail)
        tvDate = findViewById(R.id.tvDateDetail)
        tvPublisher = findViewById(R.id.tvPublisherDetail)
        wvNews = findViewById(R.id.wvNews)

        showDetailNews()
    }

    private fun showDetailNews() {
        val title = intent.getStringExtra("TITLE")
        val date = intent.getStringExtra("DATE")
        val publisher = intent.getStringExtra("PUBLISHER")
        val image = intent.getStringExtra("IMAGE")
        val news = intent.getStringExtra("NEWS")

        // Set ke view
        Picasso.get()
                .load(image)
                .resize(400, 170)
                .centerCrop()
                .into(ivNews)

        tvTitle.text = title
        tvDate.text = date
        tvPublisher.text = publisher
        wvNews.loadData(news, "text/html; charset=utf-8", "UTF-8")

    }

}
