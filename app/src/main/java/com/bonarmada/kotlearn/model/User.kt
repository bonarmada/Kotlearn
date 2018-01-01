package com.bonarmada.kotlearn.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User : RealmObject() {

    @SerializedName("last_name")
    var lastName: String? = null

    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("first_name")
    var firstName: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("username")
    var username: String? = null

    override fun toString(): String {
        return "User{" +
                "last_name = '" + lastName + '\'' +
                ",id = '" + id + '\'' +
                ",first_name = '" + firstName + '\'' +
                ",email = '" + email + '\'' +
                ",username = '" + username + '\'' +
                "}"
    }
}