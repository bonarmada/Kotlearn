package com.bonarmada.kotlearn.repository

import com.bonarmada.kotlearn.data.dao.UserDao
import com.bonarmada.kotlearn.data.remote.UserRemote
import javax.inject.Inject
import android.util.Log
import com.bonarmada.kotlearn.data.model.User

/**
 * Created by bonbonme on 12/22/2017.
 */


class UserRepository @Inject
internal constructor(private val remote: UserRemote, val dao: UserDao) {

    fun test(){
        Log.e("hehe", remote.toString())
        Log.e("hehe", dao.toString())
    }


}