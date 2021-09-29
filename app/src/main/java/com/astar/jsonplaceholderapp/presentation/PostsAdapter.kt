package com.astar.jsonplaceholderapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.astar.jsonplaceholderapp.R
import com.astar.jsonplaceholderapp.databinding.ItemPostBinding

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private val items = ArrayList<PostUi>()

    fun update(items: List<PostUi>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = when (items[position]) {
        is PostUi.Base -> 0
        is PostUi.Error -> 1
        is PostUi.Progress -> 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        0 -> PostViewHolder.Base(R.layout.item_post.makeView(parent))
        1 -> PostViewHolder.Error(R.layout.item_error_fullscreen.makeView(parent))
        else -> PostViewHolder.FullScreenProgress(R.layout.item_progress.makeView(parent))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

    }

    override fun getItemCount() = items.size

    abstract class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        open fun bind(post: PostUi) {}

        class Base(view: View) : PostViewHolder(view) {
            private val textTitle: TextView = view.findViewById(R.id.title)
            private val textBody: TextView = view.findViewById(R.id.body)

            override fun bind(post: PostUi) {
                post.map(object : PostUi.StringMapper {
                    override fun map(title: String, body: String) {
                        textTitle.text = title
                        textBody.text = body
                    }
                })
            }
        }

        class Error(view: View) : PostViewHolder(view) {
            private val message: TextView = itemView.findViewById(R.id.textMessage)

            override fun bind(post: PostUi) {
                post.map(object : PostUi.StringMapper {
                    override fun map(title: String, body: String) {
                        message.text = title
                    }
                })
            }
        }

        class FullScreenProgress(view: View) : PostViewHolder(view) {}
    }
}

private fun Int.makeView(parent: ViewGroup) =
    LayoutInflater.from(parent.context).inflate(this, parent, false)