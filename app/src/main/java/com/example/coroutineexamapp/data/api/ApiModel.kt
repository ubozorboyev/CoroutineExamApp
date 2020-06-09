package com.example.coroutineexamapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*

class ApiModel {

    val BASE_URL="https://jsonplaceholder.typicode.com/"
    //https://5e510330f2c0d300147c034c.mockapi.io/users

    private lateinit var retrofit: Retrofit

    fun getApi(): ApiInterface {

        if (!::retrofit.isInitialized){

            retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit.create(ApiInterface::class.java)
    }



}*/
