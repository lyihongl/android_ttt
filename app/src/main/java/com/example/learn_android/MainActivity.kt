package com.example.learn_android

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.MotionEvent
import android.view.View
import android.widget.*
import com.example.learn_android.controller.ttc_controller
import com.example.learn_android.model.ttc_model
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.learn_android.MESSAGE"

class MainActivity : AppCompatActivity(){

    private var turn = 0;
    lateinit var model: ttc_model

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ttc_model(this)

        val controller: ttc_controller = ttc_controller(model, this)

        for(_image in model.image_list)
        {
            println("IMAGE: "+_image)
            _image.setOnClickListener(controller)
        }
        var button = findViewById<Button>(R.id.button6)
        button.setOnClickListener(controller)
    }
}
