package com.example.learn_android.model

import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class ttc_model (context: AppCompatActivity)
{
    private var turn = 0
    val board = IntArray(9) {-1}
    val image_list: MutableList<ImageView> = mutableListOf()
    //var context: AppCompatActivity = AppCompatActivity()

    init
    {
        for(i in 1..9)
        {
            var id = context.resources.getIdentifier("imageView"+i, "id", context.packageName)
            //println("I: "+i+" "+id)
            //println("ID OF FIRST IMAGE: "+R.id.imageView1)
            //println(id)
            image_list.add(context.findViewById(id))
        }

    }

    fun update_turn()
    {
        if(turn == 0) turn = 1
        else turn = 0
    }
    fun update_board(loc: Int): Boolean
    {
        //var board_pos = y*3+x
        if(board[loc] == -1)
        {
            board[loc] = turn
            return true
        }
        else
        {
            return false
        }
    }
}