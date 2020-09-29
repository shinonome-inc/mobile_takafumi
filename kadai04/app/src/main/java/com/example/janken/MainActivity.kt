package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    enum class handType(val n: Int) {
        gu(0),
        choki(1),
        pa(2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationDrawable = AnimationDrawable()
        val frame1 = ResourcesCompat.getDrawable(resources, R.drawable.rock, null)
        val frame2 = ResourcesCompat.getDrawable(resources, R.drawable.scissors, null)
        val frame3 = ResourcesCompat.getDrawable(resources, R.drawable.paper, null)

        if (frame1 != null) {
            animationDrawable.addFrame(frame1, 100)
        }
        if (frame2 != null) {
            animationDrawable.addFrame(frame2, 100)
        }
        if (frame3 != null) {
            animationDrawable.addFrame(frame3, 100)
        }

        enemyHand.background = animationDrawable
        animationDrawable.start()

        rock.setOnClickListener {
            janken(handType.gu)
            onJankenBottonTapped( it )
        }

        scissors.setOnClickListener {
            janken(handType.choki)
            onJankenBottonTapped( it )
        }

        paper.setOnClickListener {
            janken(handType.pa)
            onJankenBottonTapped( it )
        }

    }
    fun janken(hand: handType) {

        val myHand: Int = hand.n
        val cpHand = (Math.random() * 3).toInt()


        when (cpHand) {
            0 -> enemyHand.setImageResource(R.drawable.rock)
            1 -> enemyHand.setImageResource(R.drawable.scissors)
            2 -> enemyHand.setImageResource(R.drawable.paper)
        }

        val gameResult = (cpHand - myHand + 3) % 3

        when (gameResult) {
            0 -> textView.text = "You drow"
            1 -> textView.text = "You win!"
            2 -> textView.text = "You lose"
        }

    }

    fun onJankenBottonTapped( view: View? ) {
        val intent = Intent( this, MainActivity2::class.java )
        intent.putExtra("myHand", view?.id)
        startActivity( intent )
    }
}

