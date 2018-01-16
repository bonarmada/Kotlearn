package com.bonarmada.kotlearn

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bonarmada.kotlearn.data.model.User
import com.bonarmada.kotlearn.repository.UserRepository
import com.bonarmada.kotlearn.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var repo: UserRepository

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as App).component.inject(this)

    }

    override fun onStart() {
        super.onStart()

        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        userViewModel.loggedInUser.observe(this, Observer { it ->
            if (it != null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })

        btnLogin.setOnClickListener({ view ->
            val user = User()
            user.id = 1
            user.firstName = "gege"
            repo.dao.save(user)
        })
    }
}