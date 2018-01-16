package com.bonarmada.kotlearn.di.module

import com.bonarmada.kotlearn.data.dao.UserDao
import com.bonarmada.kotlearn.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by bonbonme on 12/22/2017.
 */

@Module
class DaoModule {

    @AppScope
    @Provides
    internal fun provideUserDao(): UserDao = UserDao()

}