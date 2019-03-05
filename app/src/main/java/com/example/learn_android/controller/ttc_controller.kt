package com.example.learn_android.controller

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.learn_android.MainActivity
import com.example.learn_android.R
import com.example.learn_android.model.ttc_model
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Math.abs

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
        if(v is ImageView)
        {
            if(model.update_board(model.image_list.indexOf(v)))
            {
                model.update_turn()
            }
            model.turn_num += 1
            update_view()
        }
        else if(v is Button)
        {
            if(v.text == "Reset")
            {
                reset_board()
                update_view(true)
                Toast.makeText(context, "Reset Button Pressed", Toast.LENGTH_SHORT).show()
            }
        }
        if(model.turn_num > 3)
        {
            check_board()
        }
    }
    fun update_view(reset: Boolean = false)
    {
        val iterator = model.image_list.iterator()
        for((index, _image) in iterator.withIndex())
        {
            if(model.board[index] == 0)
            {
                set_image(_image, R.drawable.x)
            }
            else if(model.board[index] == 1)
            {
                set_image(_image, R.drawable.o)
            }
            else if(reset)
            {
                set_image(_image, R.drawable.blank)
            }
        }
    }

    fun reset_board()
    {
        for(i in model.board.indices)
        {
            model.turn = 0
            model.board[i] = -1
        }
    }

    fun set_image(v: ImageView, source: Int)
    {
        v.setImageResource(android.R.color.transparent)
        v.setImageResource(source)
    }

    fun check_board(): Boolean
    {
        return true
    }
    fun check_rows():Boolean
    {
        var sum = 0
        for(i in 0..2)
        {
            sum = 0
            for(j in 0..2)
            {
                if(model.board[i*3+j] == 0)
                {
                    sum += 1
                }
                else if(model.board[i*3+j] == 1)
                {
                    sum -= 1
                }
            }
            if(abs(sum) != 3)
            {
                return false
            }
        }
        return true
    }
}