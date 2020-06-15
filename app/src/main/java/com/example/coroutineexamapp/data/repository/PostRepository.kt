package com.example.coroutineexamapp.data.repository

import com.example.coroutineexamapp.data.api.ApiInterface
import com.example.coroutineexamapp.data.api.ApiPlaceHoler
import javax.inject.Inject

class PostRepository @Inject constructor(val apiInterface: ApiPlaceHoler){

    suspend fun getPosts() = apiInterface.getPosts()

}