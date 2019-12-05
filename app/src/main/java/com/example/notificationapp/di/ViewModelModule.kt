package com.example.notificationapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.notificationapp.viewmodel.PostsViewModelFactory
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: PostsViewModelFactory): ViewModelProvider.Factory
}