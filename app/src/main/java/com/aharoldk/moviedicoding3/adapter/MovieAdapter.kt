package com.aharoldk.moviedicoding3.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.aharoldk.moviedicoding3.R
import com.aharoldk.moviedicoding3.model.ResultsItem
import com.squareup.picasso.Picasso

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.row_main.view.*

class MovieAdapter(private val list: MutableList<ResultsItem>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var detailClickListener: DetailClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_main, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.btnDetail!!.setOnClickListener {
            if (detailClickListener != null) {
                detailClickListener!!.onItemDetailClicked(list[position].id.toString())
            }
        }

        holder.itemView.btnShare!!.setOnClickListener {
            if (detailClickListener != null) {
                detailClickListener!!.onItemDetailShareClicked(list[position].title.toString(), list[position].overview.toString(), list[position].releaseDate.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItemClickListener(itemClickListener: DetailClickListener) {
        detailClickListener = itemClickListener
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.ivPoster) internal var ivPoster: ImageView? = null
        @BindView(R.id.tvTitle) internal var tvTitle: TextView? = null
        @BindView(R.id.tvDesk) internal var tvDesk: TextView? = null
        @BindView(R.id.tvDate) internal var tvDate: TextView? = null
        @BindView(R.id.btnDetail) internal var btnDetail: Button? = null
        @BindView(R.id.btnShare) internal var btnShare: Button? = null

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(resultsItem: ResultsItem) {
            itemView.tvTitle!!.text = resultsItem.title.toString()
            itemView.tvDesk!!.text = resultsItem.overview.toString()
            itemView.tvDate!!.text = resultsItem.releaseDate.toString()

            Picasso.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185" + resultsItem.posterPath!!)
                    .into(itemView.ivPoster)

        }
    }
}
