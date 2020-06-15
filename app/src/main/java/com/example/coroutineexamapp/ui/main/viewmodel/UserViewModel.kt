package com.example.coroutineexamapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.coroutineexamapp.data.model.UserData
import com.example.coroutineexamapp.data.repository.UserRepository
import com.example.coroutineexamapp.utils.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import javax.inject.Inject

class UserViewModel @Inject constructor( private val repository: UserRepository):ViewModel(){

    fun getUsers() = liveData(Dispatchers.Main) {

        emit(Resource.loading(null))

        try {

            emit(Resource.succsess<List<UserData>>(data = repository.getUsers()))

        } catch (e:Exception){

            Log.d("TTTTT","ERRROR message ${e.message}")

            emit(Resource.error("",message = e.message ?: "Error occurred"))
        }
    }

}


@ExperimentalCoroutinesApi
fun CoroutineScope.produceSquare():ReceiveChannel<Int> =produce {
    for(i in 0..10) send(i*i)
}

@ExperimentalCoroutinesApi
fun main() = runBlocking<Unit>{

    val valuse=produceSquare()

    valuse.consumeEach {
        println(it)
    }

}