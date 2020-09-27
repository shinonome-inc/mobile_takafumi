package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class ResultActiviity : AppCompatActivity() {

    val gu = 0
    val choki = 1
    val pa = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activiity)
        val id = intent.getIntExtra("myHand", 0 )

        val myHand: Int
        myHand = when ( id ) {
            R.id.rock -> {
                gu
            }
            R.id.scissors -> {
                choki
            }
            R.id.paper -> {
                pa
            }
            else -> gu
        }

        val cpHand = ( Math.random() * 3 ).toInt()

        when ( cpHand ){
            0 -> enemyHand.setImageResource ( R.drawable.rock )
            1 -> enemyHand.setImageResource ( R.drawable.scissors )
            2 -> enemyHand.setImageResource ( R.drawable.paper )
        }

        val gameResult = ( cpHand - myHand +3 ) % 3

        when(gameResult){
            0 -> textView.text = "You drow"
            1 -> textView.text = "You win!"
            2 -> textView.text = "You lose"
        }
    }
}