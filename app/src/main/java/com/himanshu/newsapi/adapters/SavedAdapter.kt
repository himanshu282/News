package com.himanshu.newsapi.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.himanshu.newsapi.ClickInterface
import com.himanshu.newsapi.R
import com.himanshu.newsapi.apimodels.Articles
import com.himanshu.newsapi.database.News


class SavedAdapter(val context : Context, val interfacess : ClickInterface,var newsList:List<News>) : RecyclerView.Adapter<SavedAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val deleteButton : ImageView = itemView.findViewById(R.id.delete_btn)
        val title : TextView = itemView.findViewById(R.id.text_view_three)
        val description : TextView = itemView.findViewById(R.id.text_view_four)
        val urlToImage : ImageView = itemView.findViewById(R.id.demo_image1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rows_two,parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: SavedAdapter.MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        Log.d("item", "onBindViewHolder: " + currentItem)
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.urlToImage.load(currentItem.urlToImage)
        holder.deleteButton.setOnClickListener{
            interfacess.onClick(currentItem)
        }
    }

    override fun getItemCount() = newsList.size

}