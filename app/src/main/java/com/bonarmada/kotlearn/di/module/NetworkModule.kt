package com.bonarmada.kotlearn.di.module

import android.content.Context
import com.bonarmada.kotlearn.di.scope.AppScope
import com.google.gson.Gson
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber



/**
 * Created by bonbonme on 12/22/2017.
 */


@Module(includes = arrayOf(MapperModule::class, ContextModule::class))
class NetworkModule(private val baseUrl: String) {

    @AppScope
    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i("OkHttp", message) })
    }

    @AppScope
    @Provides
    internal fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @AppScope
    @Provides
    internal  fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(httpClient)
                .build()
    }

    @AppScope
    @Provides
    internal fun providePicasso(context: Context, http3Downloader: OkHttp3Downloader): Picasso{
        return  Picasso.Builder(context).downloader(http3Downloader).build()
    }

    @AppScope
    @Provides
    internal fun provideHttpDownloader(httpClient: OkHttpClient): OkHttp3Downloader{
        return OkHttp3Downloader(httpClient);
    }
}