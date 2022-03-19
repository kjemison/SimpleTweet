package com.codepath.apps.restclienttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet

class TweetsAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivProfileImage = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate item layout
        val view = inflater.inflate(R.layout.item_tweet, parent, false)

        return ViewHolder(view)
    }

    // Populate data into item through viewholder
    override fun onBindViewHolder(holder: TweetsAdapter.ViewHolder, position: Int) {

        // Fetch data model based on position
        val tweet: Tweet = tweets.get(position)

        // Set item views from fetched data object
        holder.tvUserName.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body
        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).into(holder.ivProfileImage)

    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    // Clean all elements of the recycler
    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }
}