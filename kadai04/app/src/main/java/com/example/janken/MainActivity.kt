package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    enum class handType(val n: Int) {
        gu(0),
        choki(1),
        pa(2)
    }

    private lateinit var jankenAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jankenImage = findViewById<ImageView>(R.id.enemyHand).apply {
            setBackgroundResource(R.drawable.animation_list)
            jankenAnimation = background as AnimationDrawable
        }

        jankenImage.setOnClickListener({ jankenAnimation.start() })

            rock.setOnClickListener {
                bottonAnimation(rock)
                janken(handType.gu)
            }

            scissors.setOnClickListener {
                bottonAnimation(scissors)
                janken(handType.choki)
            }

            paper.setOnClickListener {
                bottonAnimation(paper)
                janken(handType.pa)

            }

    }

    fun janken(hand: handType) {
        val myHand: Int = hand.n
        val cpHand = (Math.random() * 3).toInt()

        when ( cpHand ) {
            0 -> enemyHand.setImageResource ( R.drawable.rock)
            1 -> enemyHand.setImageResource ( R.drawable.scissors)
            2 -> enemyHand.setImageResource ( R.drawable.paper)
        }

        val gameResult = ( cpHand - myHand + 3) % 3

        when (gameResult) {
            0 -> textView.text = "You drow"
            1 -> textView.text = "You win!"
            2 -> textView.text = "You lose"
        }
    }

    fun bottonAnimation( imageBotton:ImageButton ) {
        val fadeInAnimation = AlphaAnimation(0.0f,1.0f)
        val fadeOutAnimation = AlphaAnimation(0.0f,1.0f)

        fadeOutAnimation.duration = 500
        fadeOutAnimation.fillAfter = true
        imageBotton.animation = fadeOutAnimation
        fadeInAnimation.duration = 500
        fadeInAnimation.fillAfter= true
        imageBotton.animation = fadeInAnimation

    }
}
