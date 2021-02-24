package com.example.apiApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class Adapter(private val homeFeed: Array<HomeFeed>) : RecyclerView.Adapter<Adapter.CustomViewHolder>() {
    //リスナー格納変数
    lateinit var listener: OnItemClickListener

    //recyclerviewのコンテンツサイズ
    override fun getItemCount(): Int {
        return homeFeed.count()
}

    //getItemCount,onCreateViewHolder,onBindViewHolderを実装
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row, parent, false)

        return CustomViewHolder(cellForRow)
    }

    //ViewHolderViewに挿入するもの
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val article = homeFeed.get(position)

        holder.author.text = article.title

        if (article.user.name == "") {
            holder.author.text = "名無しの投稿者"
        } else {
            holder.author.text = article.user.name
        }

        //タップしたとき
        holder.view.setOnClickListener {
            listener.onItemClickListener(it, position, article.url)
        }
    }

    //インターフェイスの作成
    interface OnItemClickListener : AdapterView.OnItemClickListener {
        fun onItemClickListener(view: View, position: Int, url: String)
    }

    //リスナー
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val author = view.author
        val title = view.title
    }
}
