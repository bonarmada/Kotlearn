package com.bonarmada.kotlearn.di.module

import com.bonarmada.kotlearn.di.scope.AppScope
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

/**
 * Created by bonbonme on 12/22/2017.
 */

@Module
class MapperModule {

    @AppScope
    @Provides
    internal fun provideGson(): Gson {
        val builder = GsonBuilder()
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.create()
    }
}