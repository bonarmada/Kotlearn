package com.bonarmada.kotlearn.di.component

import com.bonarmada.kotlearn.LoginActivity
import com.bonarmada.kotlearn.MainActivity
import com.bonarmada.kotlearn.di.module.DaoModule
import com.bonarmada.kotlearn.di.module.RemoteModule
import com.bonarmada.kotlearn.di.module.ViewModelModule
import com.bonarmada.kotlearn.di.scope.AppScope
import dagger.Component
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by bonbonme on 12/22/2017.
 */

@AppScope
@Component(modules = arrayOf(DaoModule::class, RemoteModule::class, ViewModelModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: LoginActivity)
}