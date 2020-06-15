package com.example.coroutineexamapp.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.coroutineexamapp.data.repository.PostRepository
import com.example.coroutineexamapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class PostViewModel @Inject constructor(private val posRepo:PostRepository):ViewModel(){



    fun getPosts() = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))

        try {
            emit(Resource.succsess(posRepo.getPosts()))

        }catch (e :Exception){

            emit(Resource.error("",e.message?:"Error occurred"))
        }

    }



}