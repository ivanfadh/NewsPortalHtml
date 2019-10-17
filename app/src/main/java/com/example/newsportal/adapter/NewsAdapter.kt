package com.example.newsportal.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.example.newsportal.R
import com.example.newsportal.model.ArticlesItem
import com.example.newsportal.view.newsdetail.DetailActivity
import com.squareup.picasso.Picasso

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.w3c.dom.Text

class NewsAdapter(internal var context: Context, internal var mNewsList: List<ArticlesItem>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val mView = LayoutInflater.from(context).inflate(R.layout.news_list, parent, false)

        //hubungkan dengan holder
        return NewsHolder(mView)
    }


    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        holder.tvTitle.text = mNewsList[position].title


        val string = "2019-04-17T04:00:00.000Z"
        val formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = LocalDate.parse(string, formatter)

        holder.tvDate.text = date.toString()

        holder.tvPublisher.text = mNewsList[position].source!!.name

        Picasso.get()
                .load(mNewsList[position].urlToImage)
                .resize(400, 170)
                .centerCrop()
                .into(holder.ivNews)

        // Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener {
            // Mulai activity Detail
            val varIntent = Intent(context, DetailActivity::class.java)
            // sisipkan data ke intent
            varIntent.putExtra("TITLE", mNewsList[position].title)
            varIntent.putExtra("DATE", date.toString())
            varIntent.putExtra("PUBLISHER", mNewsList[position].source!!.name)
            varIntent.putExtra("IMAGE", mNewsList[position].urlToImage)
            varIntent.putExtra("NEWS", mNewsList[position].content)


            // method startActivity cma bisa di pake di activity/fragment
            // jadi harus masuk ke context dulu
            context.startActivity(varIntent)
        }
    }

    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvDate: TextView
        var tvPublisher: TextView
        var ivNews: ImageView

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            tvDate = itemView.findViewById(R.id.tvDate)
            tvPublisher = itemView.findViewById(R.id.tvPublisher)
            ivNews = itemView.findViewById(R.id.ivNews)

        }

    }
    
    override fun getItemCount(): Int {

        return mNewsList.size
    }

}
