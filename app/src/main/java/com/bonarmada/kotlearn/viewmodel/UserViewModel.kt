package com.bonarmada.kotlearn.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.bonarmada.kotlearn.data.dao.UserDao
import com.bonarmada.kotlearn.data.model.User
import com.bonarmada.kotlearn.repository.UserRepository
import javax.inject.Inject

/**
 * Created by bonbonme on 1/3/2018.
 */

class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var userId: Int = 0
    lateinit var user: LiveData<User>
    lateinit var loggedInUser: LiveData<User>

    init {
        subscribe()
    }

    fun subscribe() {
        val users = repository.dao.getAsLiveData()
        this.user = Transformations.map(users, { users ->
            Log.e("TAG", users.size.toString())
            repository.dao.get(userId) })
        this.loggedInUser = Transformations.map(users, { users -> repository.dao.profile() })
    }
}
