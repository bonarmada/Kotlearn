package com.bonarmada.kotlearn.di.module

import com.bonarmada.kotlearn.data.remote.UserRemote
import com.bonarmada.kotlearn.di.scope.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by bonbonme on 12/22/2017.
 */

@Module(includes = arrayOf(NetworkModule::class))
class RemoteModule {

    @AppScope
    @Provides
    internal fun provideUserRemote(retrofit: Retrofit): UserRemote{
        return  retrofit.create(UserRemote::class.java)
    }
}