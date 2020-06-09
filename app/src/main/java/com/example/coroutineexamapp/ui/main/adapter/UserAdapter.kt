package com.example.coroutineexamapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineexamapp.R
import com.example.coroutineexamapp.data.model.UserData
import com.example.coroutineexamapp.databinding.UserItemBinding
import com.squareup.picasso.Picasso

class UserAdapter(val context:Context) :RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    private val userList= arrayListOf<UserData>()

    inner class ViewHolder(val itemBinding: UserItemBinding):RecyclerView.ViewHolder(itemBinding.root){

        fun bind(userData: UserData){
            itemBinding.email.text = userData.email
            itemBinding.name.text = userData.name
            itemBinding.userId.text = userData.id
            Picasso.Builder(context).build().load(userData.avatar).placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(itemBinding.imageUser)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        val itemBinding=UserItemBinding.inflate(inflater,parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(userList[position])
    }


    fun setData(ls:List<UserData>){

        userList.addAll(ls)
        notifyDataSetChanged()
    }
}