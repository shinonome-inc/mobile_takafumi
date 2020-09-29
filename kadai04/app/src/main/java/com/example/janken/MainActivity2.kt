package com.example.janken

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity() {

    enum class handType(val n: Int) {
        gu(0),
        choki(1),
        pa(2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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
            onJankenBottonTapped1( it)
        }

        scissors.setOnClickListener {
            janken(handType.choki)
            onJankenBottonTapped1( it )
        }

        paper.setOnClickListener {
            janken(handType.pa)
            onJankenBottonTapped1( it )
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

    fun onJankenBottonTapped1( view: View? ) {
        val intent = Intent( this, MainActivity::class.java )
        intent.putExtra("myHand", view?.id)
        startActivity( intent )
    }
}