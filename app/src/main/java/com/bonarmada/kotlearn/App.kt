package com.bonarmada.kotlearn

import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bonarmada.kotlearn.di.component.AppComponent
import com.bonarmada.kotlearn.di.component.DaggerAppComponent
import com.bonarmada.kotlearn.di.module.ContextModule
import com.bonarmada.kotlearn.di.module.NetworkModule
import io.realm.Realm

class App : Application() {
    val TAG = this.javaClass.simpleName
    val baseUrl = "http://54.169.44.247:5001/voxr/api/"
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .networkModule(NetworkModule(baseUrl))
                .build()
    }
}