package com.example.newsportal.view.texview

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import com.example.newsportal.R
import com.sysdata.kt.htmltextview.SDHtmlTextView

class fromHtmlActivityFail : AppCompatActivity() {
    internal lateinit var tvFromHtml1: SDHtmlTextView
    internal lateinit var stringHtml1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_html)

        tvFromHtml1 = findViewById(R.id.tvHtmlFromHtml)
        stringHtml1 = resources.getString(R.string.html_datafail)

//        tvFromHtml1.text = Html.fromHtml(stringHtml1,0)
//        tvFromHtml1.text = HtmlSpanner().fromHtml(stringHtml1)
        tvFromHtml1.htmlText = stringHtml1
    }

}
