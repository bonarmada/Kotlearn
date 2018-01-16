package com.bonarmada.kotlearn.di.module

import com.bonarmada.kotlearn.di.ViewModelKey
import com.bonarmada.kotlearn.di.scope.AppScope
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import com.bonarmada.kotlearn.viewmodel.UserViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.bonarmada.kotlearn.viewmodel.ViewModelFactory
import javax.inject.Provider


/**
 * Created by bonbonme on 12/22/2017.
 */

@Module
abstract class ViewModelModule {
    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    // Factory
    @AppScope
    @Binds abstract fun bindViewModelFactory(vmFactory: ViewModelFactory): ViewModelProvider.Factory
}