package com.example.coroutineexamapp.di

import com.example.coroutineexamapp.data.api.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton



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

}