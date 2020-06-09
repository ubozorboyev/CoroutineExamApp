package com.example.coroutineexamapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutineexamapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
/*

fun maian() = runBlocking { // this: CoroutineScope

      launch {
          delay(200)
          println("Task One")             //   3 1 2 5 4 6
      }

    coroutineScope {

        launch {
            delay(500)
            println("Task Two")
        }

        delay(100)
        println("Task Three")


        coroutineScope {
            delay(1000)
            println("Task  Five")
        }

        println("Task Four")
    }
    println("Task  Six")

}
*/
