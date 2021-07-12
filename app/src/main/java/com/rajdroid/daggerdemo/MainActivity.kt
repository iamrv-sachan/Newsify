package com.rajdroid.daggerdemo

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajdroid.daggerdemo.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {
    private val TAG = "ankit"

   

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var mainActivityViewModel: MainActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this, providerFactory).get(MainActivityViewModel::class.java)

        recycler_view.layoutManager= LinearLayoutManager(applicationContext)


        lifecycleScope.launch {
            val result = mainActivityViewModel.getUser("top headlines")
            val mAdapter = NewsAdapter(result!!.articles!!)
            recycler_view.apply {
                adapter=mAdapter


            }
        }

        btnsearch.setOnClickListener {
            if(tv_search.text.isNotEmpty())
            {
                val name=tv_search.text.toString()
                Log.d(TAG, "onCreate: $name")

                lifecycleScope.launch {
                    val result = mainActivityViewModel.getUser(name)
                    val mAdapter = NewsAdapter(result!!.articles!!)
                    recycler_view.apply {
                        adapter=mAdapter


                    }
                }
            }


        }



        cricket.setOnClickListener {
            val name="cricket"
            Log.d(TAG, "onCreate: $name")

            lifecycleScope.launch {
                val result = mainActivityViewModel.getUser(name)
                val mAdapter = NewsAdapter(result!!.articles!!)
                recycler_view.apply {
                    adapter=mAdapter


                }
            }

        }

        pubg.setOnClickListener {
            val name="pubg"
            Log.d(TAG, "onCreate: $name")

            lifecycleScope.launch {
                val result = mainActivityViewModel.getUser(name)
                val mAdapter = NewsAdapter(result!!.articles!!)
                recycler_view.apply {
                    adapter=mAdapter


                }
            }

        }


        education.setOnClickListener {
            val name="education"
            Log.d(TAG, "onCreate: $name")

            lifecycleScope.launch {
                val result = mainActivityViewModel.getUser(name)
                val mAdapter = NewsAdapter(result!!.articles!!)
                recycler_view.apply {
                    adapter=mAdapter


                }
            }

        }

        technology.setOnClickListener {
            val name="technology"
            Log.d(TAG, "onCreate: $name")

            lifecycleScope.launch {
                val result = mainActivityViewModel.getUser(name)
                val mAdapter = NewsAdapter(result!!.articles!!)
                recycler_view.apply {
                    adapter=mAdapter


                }
            }

        }

        cars.setOnClickListener {
            val name="cars"
            Log.d(TAG, "onCreate: $name")

            lifecycleScope.launch {
                val result = mainActivityViewModel.getUser(name)
                val mAdapter = NewsAdapter(result!!.articles!!)
                recycler_view.apply {
                    adapter=mAdapter


                }
            }

        }
        
       






    }


}