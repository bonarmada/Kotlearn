package com.bonarmada.kotlearn.data.dao

import com.bonarmada.kotlearn.model.User
import io.realm.Realm

/**
 * Created by bonbonme on 12/7/2017.
 */

class UserDao : DaoImpl<User>(User::class.java) {
    companion object {
        fun profile(): User? {
            val realm = Realm.getDefaultInstance()
            return realm.where(User::class.java).findFirst()
        }
    }
}