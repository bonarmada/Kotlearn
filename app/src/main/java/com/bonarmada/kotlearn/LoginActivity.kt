package com.bonarmada.kotlearn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bonarmada.kotlearn.data.dao.UserDao
import com.bonarmada.kotlearn.model.User

class LoginActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = UserDao()

        val newUser = User()
        newUser.id = 1;
        newUser.firstName = "bon arada"
        dao.save(newUser)


        dao.get().forEach{
            Log.e("hhe", "hello")
        }
    }
}