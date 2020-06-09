package com.example.coroutineexamapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.coroutineexamapp.data.repository.UserRepository
import com.example.coroutineexamapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class UserViewModel @Inject constructor( private val repository: UserRepository):ViewModel(){


    fun getUsers() = liveData(Dispatchers.Main) {

        emit(Resource.loading(null))

        try {

            emit(Resource.succsess(data = repository.getUsers()))

        } catch (e:Exception){

            Log.d("TTTTT","ERRROR message ${e.message}")

            emit(Resource.error("",message = e.message ?: "Error occurred"))
        }
    }

}