package com.himanshu.newsapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.himanshu.newsapi.ClickInterface
import com.himanshu.newsapi.HomeViewModel
import com.himanshu.newsapi.R
import com.himanshu.newsapi.adapters.SavedAdapter
import com.himanshu.newsapi.apimodels.Articles
import com.himanshu.newsapi.database.News


class SavedFragment : Fragment(), ClickInterface{
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var savedAdapter : SavedAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newRecyclerView = view.findViewById(R.id.recycler_view_two)
        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.setHasFixedSize(true)

        homeViewModel.getAll(requireContext()).observe(viewLifecycleOwner
        ) {
            savedAdapter= SavedAdapter(requireContext(),this,it)
            newRecyclerView.adapter=savedAdapter
        }


    }

    override fun onClick(news: Any) {
        homeViewModel.delete(news as News,requireContext())
    }



}