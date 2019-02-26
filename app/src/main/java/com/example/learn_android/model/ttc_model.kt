package com.example.learn_android.model

import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class ttc_model (context: AppCompatActivity)
{
    var turn = 0
    val board = IntArray(9) {-1}
    val image_list: MutableList<ImageView> = mutableListOf()

    init
    {
        for(i in 1..9)
        {
            var id = context.resources.getIdentifier("imageView"+i, "id", context.packageName)
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