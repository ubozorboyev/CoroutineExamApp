package com.example.coroutineexamapp.data.api

import com.example.coroutineexamapp.data.model.UserData
import retrofit2.http.GET

interface ApiInterface {


    @GET(".")
    suspend fun getUsers():List<UserData>

    @GET("posts/")
    suspend fun getPosts()


}