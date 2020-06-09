package com.example.coroutineexamapp.data.repository

import com.example.coroutineexamapp.data.api.ApiInterface
import javax.inject.Inject

class UserRepository @Inject constructor(val apiInterface: ApiInterface){

    suspend fun getUsers() = apiInterface.getUsers()


}