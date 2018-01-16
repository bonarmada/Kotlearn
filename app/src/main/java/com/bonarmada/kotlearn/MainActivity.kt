package com.bonarmada.kotlearn

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bonarmada.kotlearn.repository.UserRepository
import com.bonarmada.kotlearn.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.bonarmada.kotlearn.data.model.User
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var repo: UserRepository

    lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Perform injection so that when this call returns all dependencies will be available for use.
        (application as App).component.inject(this)
    }

    override fun onStart() {
        super.onStart()

        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        userViewModel.loggedInUser.observe(this, Observer { it ->
            if (it == null) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        })

        btnLogout.setOnClickListener({ view ->
            repo.dao.clear()
        })
    }
}