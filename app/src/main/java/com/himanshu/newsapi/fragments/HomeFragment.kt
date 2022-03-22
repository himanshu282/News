package com.himanshu.newsapi.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.himanshu.newsapi.ApiClient
import com.himanshu.newsapi.ClickInterface
import com.himanshu.newsapi.HomeViewModel
import com.himanshu.newsapi.adapters.MyAdapter
import com.himanshu.newsapi.R
import com.himanshu.newsapi.apimodels.Articles
import com.himanshu.newsapi.apimodels.DataItem
import com.himanshu.newsapi.database.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(),ClickInterface {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = MyAdapter(requireContext(),this)
        newRecyclerView = view.findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.adapter = myAdapter

        val apiCall = ApiClient.create().getData()
        apiCall.enqueue(object : Callback<DataItem?> {
            override fun onResponse(call: Call<DataItem?>, response: Response<DataItem?>) {
                Log.d(TAG, "onResponse: " +response)
                response.body()?.let {
                    myAdapter.setDataItems(it)
                }

            }

            override fun onFailure(call: Call<DataItem?>, t: Throwable) {
                Log.d("apiResponse", "message" +t)
            }
        })
    }

    override fun onClick(articles: Any) {
        articles as Articles
        var news:News=News(articles.description!!,articles.title!!,articles.urlToImage!!)
        homeViewModel.insert(news,requireContext())
    }


}


