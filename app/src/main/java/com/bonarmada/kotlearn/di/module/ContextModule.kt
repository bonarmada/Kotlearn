package com.bonarmada.kotlearn.di.module

import android.content.Context
import com.bonarmada.kotlearn.di.scope.AppScope
import dagger.Module
import dagger.Provides



/**
 * Created by bonbonme on 12/22/2017.
 */

@Module
class ContextModule constructor(private val context: Context){

    @AppScope
    @Provides
    internal fun provideContext(): Context = context
}