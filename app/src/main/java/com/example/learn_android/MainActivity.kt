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

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var turn = 0;
    //public val model = ttc_model()
    lateinit var model: ttc_model

    override fun onClick(v: View?)
    {
        update_turn()
        //Toast.makeText(this, ""+event?.getX(0), Toast.LENGTH_LONG).show()
        //var view = findViewById<ImageView>(R.id.imageView5)
        //var layout = findViewById<TableLayout>(R.id.table_layout)
        //Toast.makeText(this, "image shown? "+view.isShown(), Toast.LENGTH_LONG).show()
        //view.setImageResource(android.R.color.transparent)
        //view.setImageResource(R.drawable.o)
        //view.setImageResource(R.drawable.x)
        //return true
    }
    fun update_turn()
    {
        Toast.makeText(this, "Updating turn: " + turn, Toast.LENGTH_SHORT).show()
        if(turn == 0)
        {
            turn = 1
            //set_image(findViewById(R.id.imageView5), R.drawable.o)
            //set_image(findViewById(R.id.imageView), R.drawable.o)
            //set_image(findViewById(R.id.imageView2), R.drawable.o)
        }
        else
        {
            turn = 0
            //set_image(findViewById(R.id.imageView5), R.drawable.x)
            //set_image(findViewById(R.id.imageView), R.drawable.x)
            //set_image(findViewById(R.id.imageView2), R.drawable.x)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //var view = findViewById<View>(R.id.entire_view)
        setContentView(R.layout.activity_main)

        model = ttc_model(this)
        val controller: ttc_controller = ttc_controller(model, this)
        //var res: Resources = Resources()
        //var image_list = mutableListOf<ImageView>()
        for(_image in model.image_list)
        {
            println("IMAGE: "+_image)
            _image.setOnClickListener(controller)
            //println("IMAGE ID: "+_image.id)
        }
        //view.setOnTouchListener(this)
        //var image_1 = findViewById<View>(R.id.imageView1)
        //view.setOnClickListener(controller)
        //var image_view = findViewById<ImageView>(R.id.imageView4)
        //Toast.makeText(this, "Image View shown? "+image_view.isShown(), Toast.LENGTH_LONG).show()
        //image_view.setImageResource(R.drawable.x)

        //var myLayout = null
        //myLayout = findViewById<RelativeLayout>(R.id.myLayout)
    }
    //fun onClick(v: View)
    //{
    //
    //}

    //fun sendMessage(view: View)
    //{
    //    val editText = findViewById<EditText>(R.id.editText2)
    //    val message = editText2.text.toString()
    //    val intent = Intent(this, DisplayMessageActivity::class.java).apply {  putExtra(EXTRA_MESSAGE, message) }
    //    startActivity(intent)
    //}
}
