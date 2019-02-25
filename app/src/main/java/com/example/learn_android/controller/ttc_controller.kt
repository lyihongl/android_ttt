package com.example.learn_android.controller

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.learn_android.MainActivity
import com.example.learn_android.R
import com.example.learn_android.model.ttc_model
import kotlinx.android.synthetic.main.activity_main.view.*

class ttc_controller(_model: ttc_model, _context: AppCompatActivity) : View.OnClickListener
{
    var model: ttc_model
    var context: AppCompatActivity
    init
    {
        model = _model
        context = _context
    }
    override fun onClick(v: View?)
    {
        Toast.makeText(context, "View name: "+v?.getTag(), Toast.LENGTH_SHORT).show()
        if(model.update_board(model.image_list.indexOf(v)))
        {
            model.update_turn()
        }
        update_view()
        //v?.getTag()
    }
    fun update_view()
    {
        val iterator = model.image_list.iterator()
        for((index, _image) in iterator.withIndex())
        {
            if(model.board[index] == 0)
            {
                //_image.setImageResource(R.drawable.x)
                set_image(_image, R.drawable.x)
            }
            else if(model.board[index] == 1)
            {
                set_image(_image, R.drawable.o)
                //_image.setImageResource(R.drawable.o)
            }
        }
    }
    fun set_image(v: ImageView, source: Int)
    {
        v.setImageResource(android.R.color.transparent)
        v.setImageResource(source)
    }

}