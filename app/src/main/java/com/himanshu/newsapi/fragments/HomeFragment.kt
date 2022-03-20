package com.himanshu.newsapi.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.himanshu.newsapi.ApiClient
import com.himanshu.newsapi.adapters.MyAdapter
import com.himanshu.newsapi.R
import com.himanshu.newsapi.apimodels.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = MyAdapter(requireContext())
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


}


