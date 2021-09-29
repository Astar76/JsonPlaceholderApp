package com.astar.jsonplaceholderapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astar.jsonplaceholderapp.core.MainApp
import com.astar.jsonplaceholderapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = (application as MainApp).mainViewModel
        val postsAdapter = PostsAdapter()

        binding.recycler.apply {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            layoutManager = LinearLayoutManager(context)
            adapter = postsAdapter
        }

        viewModel.observe(this, { posts ->
            Log.e("MainActivity", "SIZE SIZE SIZE ${posts.size} ")
            postsAdapter.update(posts)
        })
        viewModel.fetchPosts()
    }
}