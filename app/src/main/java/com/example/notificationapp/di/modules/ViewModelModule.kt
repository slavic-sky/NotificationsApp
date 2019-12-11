package com.example.notificationapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.notificationapp.viewmodel.PostListViewModel
import com.example.notificationapp.viewmodel.PostsViewModelFactory
import com.example.notificationapp.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    abstract fun bindViewModelFactory(factory: PostsViewModelFactory): ViewModelProvider.Factory
}