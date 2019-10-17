package com.example.newsportal.view.texview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.newsportal.R
import android.text.method.LinkMovementMethod
import com.sysdata.kt.htmltextview.SDHtmlTextView


class fromHtmlActivity : AppCompatActivity() {
    internal lateinit var tvFromHtml: SDHtmlTextView
    internal lateinit var stringHtml: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_html)

        tvFromHtml = findViewById(R.id.tvHtmlFromHtml)
        stringHtml = resources.getString(R.string.html_data)

//        tvFromHtml.text = Html.fromHtml(stringHtml, 0)
//        tvFromHtml.text = HtmlSpanner().fromHtml(stringHtml)
        tvFromHtml.htmlText = stringHtml

/*        tvFromHtml.setText(Html.fromHtml(stringHtml, Html.ImageGetter { source ->
            val drawable: Drawable
            val dourceId = applicationContext
                    .resources
                    .getIdentifier(source, "drawable", packageName)

            drawable = applicationContext
                    .resources
                    .getDrawable(dourceId)

            drawable.setBounds(
                    0,
                    0,
                    drawable.intrinsicWidth,
                    drawable.intrinsicHeight)

            drawable
        }, null))*/

        tvFromHtml.movementMethod = LinkMovementMethod.getInstance()
    }
}
