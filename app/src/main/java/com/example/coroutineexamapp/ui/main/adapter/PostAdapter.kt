package com.example.coroutineexamapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineexamapp.data.model.PostItemData
import com.example.coroutineexamapp.databinding.PostItemBinding

class PostAdapter :RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    private val postList = arrayListOf<PostItemData>()

    inner class ViewHolder(val postItemBinding: PostItemBinding):RecyclerView.ViewHolder(postItemBinding.root){

        fun bind(postItemData: PostItemData){

            postItemBinding.title.text = postItemData.title
            postItemBinding.postBody.text = postItemData.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(PostItemBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount(): Int {

        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(postList[position])
    }

    fun setData(ls:List<PostItemData>){
        postList.addAll(ls)
        notifyDataSetChanged()
    }

}