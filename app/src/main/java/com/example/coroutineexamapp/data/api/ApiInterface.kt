package com.example.coroutineexamapp.data.api

import com.example.coroutineexamapp.data.model.PostItemData
import com.example.coroutineexamapp.data.model.UserData
import retrofit2.http.GET

interface ApiInterface {

    @GET(".")
    suspend fun getUsers():List<UserData>
}

interface ApiPlaceHoler{

    @GET("posts/")
    suspend fun getPosts():List<PostItemData>

}