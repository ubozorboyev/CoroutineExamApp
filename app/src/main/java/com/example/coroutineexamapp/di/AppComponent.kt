package com.example.coroutineexamapp.di

import com.example.coroutineexamapp.App
import com.example.coroutineexamapp.ui.main.view.UserFragment
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(userFragment: UserFragment)

    fun inject(app:App)

}