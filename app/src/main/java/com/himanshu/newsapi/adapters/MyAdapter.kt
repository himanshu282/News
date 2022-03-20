package com.himanshu.newsapi.adapters

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.himanshu.newsapi.R
import com.himanshu.newsapi.apimodels.DataItem
import timber.log.Timber


class MyAdapter(val context : Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var newsList: DataItem = DataItem()
    class  MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title : TextView =itemView.findViewById(R.id.text_view)
        val description : TextView = itemView.findViewById(R.id.text_view_two)
        val urlToImage : ImageView = itemView.findViewById(R.id.demo_image)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataItems(data: DataItem) {
        newsList = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.rows,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList.articles[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.urlToImage.load(currentItem.urlToImage)


        Timber.d("onBindViewHolder: ")
    }



    override fun getItemCount() = newsList.articles.size


}