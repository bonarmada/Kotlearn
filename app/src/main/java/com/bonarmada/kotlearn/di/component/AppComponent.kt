package com.bonarmada.kotlearn.di.component

import com.bonarmada.kotlearn.MainActivity
import com.bonarmada.kotlearn.di.module.DaoModule
import com.bonarmada.kotlearn.di.module.RemoteModule
import com.bonarmada.kotlearn.di.scope.AppScope
import dagger.Component
import dagger.Module

/**
 * Created by bonbonme on 12/22/2017.
 */

@AppScope
@Component(modules = arrayOf(DaoModule::class, RemoteModule::class))
interface AppComponent {
    fun inject(activity: MainActivity)
}