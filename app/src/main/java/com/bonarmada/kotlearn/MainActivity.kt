package com.bonarmada.kotlearn

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bonarmada.kotlearn.R.id.hello_world
import com.bonarmada.kotlearn.repository.UserRepository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Perform injection so that when this call returns all dependencies will be available for use.
        (application as App).component.inject(this)
    }

    override fun onStart() {
        super.onStart()

        userRepository.test()

        hello_world.text = "burger king"
        hello_world.setOnClickListener { Log.e("hehe", "onclick") }
    }
}