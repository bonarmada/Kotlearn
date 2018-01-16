package com.bonarmada.kotlearn.data.remote

import com.bonarmada.kotlearn.data.model.Password
import com.bonarmada.kotlearn.data.model.User
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST



/**
 * Created by bonbonme on 12/7/2017.
 */


interface UserRemote {
    @POST("login")
    fun login(@Body user: User): Single<Response<User>>

    @POST("users")
    fun register(@Body user: User): Single<Response<User>>


    // Password remote
    @POST("password/forgot")
    fun forgot(@Body password: Password): Single<Response<String>>

    @POST("password/verify")
    fun verify(@Body password: Password): Single<Response<String>>

    @POST("password/reset")
    fun reset(@Body password: Password): Single<Response<String>>
}