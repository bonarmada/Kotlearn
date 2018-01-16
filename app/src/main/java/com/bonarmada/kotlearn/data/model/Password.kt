package com.bonarmada.kotlearn.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by bonbonme on 12/7/2017.
 */

class Password {

    @SerializedName("code")
    @Expose
    var code: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("password")
    @Expose
    var password: String? = null

    override fun toString(): String {
        return "Password{" +
                "code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}