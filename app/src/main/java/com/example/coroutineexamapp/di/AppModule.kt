package com.example.coroutineexamapp.di

import com.example.coroutineexamapp.data.api.ApiInterface
import com.example.coroutineexamapp.data.api.ApiPlaceHoler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



const val PLACE_BASE = "https://jsonplaceholder.typicode.com/"
const val BASEURL="https://5e510330f2c0d300147c034c.mockapi.io/users/"
//https://5e510330f2c0d300147c034c.mockapi.io/users/

@Module
class AppModule{

    @Provides
    fun getRestApiInterface():ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }

    @Provides
    fun getPostApi(): ApiPlaceHoler {
        return Retrofit.Builder()
            .baseUrl(PLACE_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiPlaceHoler::class.java)
    }
}