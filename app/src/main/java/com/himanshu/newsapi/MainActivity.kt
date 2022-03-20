package com.himanshu.newsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.himanshu.newsapi.database.News
import com.himanshu.newsapi.database.NewsDatabase
import com.himanshu.newsapi.fragments.HomeFragment
import com.himanshu.newsapi.fragments.SavedFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
//    private lateinit var newRecyclerView: RecyclerView
//    private var myAdapter = MyAdapter(this)
    lateinit var database: NewsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navBar : BottomNavigationView = findViewById(R.id.navBar)

//        newRecyclerView = findViewById(R.id.recycler_view)
//        newRecyclerView.layoutManager = LinearLayoutManager(this)
//        newRecyclerView.adapter = myAdapter
//
//        val apiCall = ApiClient.create().getData()
//        apiCall.enqueue(object : Callback<DataItem?> {
//            override fun onResponse(call: Call<DataItem?>, response: Response<DataItem?>) {
//                response.body()?.let { myAdapter.setDataItems(it) }
//            }
//
//            override fun onFailure(call: Call<DataItem?>, t: Throwable) {
//                Log.d("apiResponse", "${t}")
//            }
//        })

//        database= Room.databaseBuilder(applicationContext, NewsDatabase::class.java, "newsDB").build()
//

        database = NewsDatabase.getDatabase(this)

//        GlobalScope.launch {
//            database.newsDao().delete(News(2,"eeae","afasfsfsdfdafdfad","asssssssssssssssssss"))
//            database.newsDao().insert(News(2,"eeae","afasfsfsdfdafdfad","asssssssssssssssssss"))
//        }
        navBar.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home -> makeCurrentFragment(HomeFragment())
                R.id.saved -> makeCurrentFragment(SavedFragment())
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame1,fragment)
            commit()
        }
    }


}