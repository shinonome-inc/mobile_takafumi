package com.example.janken

import android.animation.ValueAnimator
import android.graphics.drawable.Animatable2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.os.Handler
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

        jankenAnimation.start()

        rock.setOnClickListener {
            janken(handType.gu)
        }

        scissors.setOnClickListener {
            janken(handType.choki)
        }

        paper.setOnClickListener {
            janken(handType.pa)
        }

    }

    fun janken(hand: handType) {
        val myHand: Int = hand.n
        val cpHand = (Math.random() * 3).toInt()
        val handler = Handler()
        var runnable = Runnable {}
        var i: Int = 0

        runnable = Runnable {
            i++

            if (i >= 20) {
                when (cpHand) {
                    0 -> enemyHand.setBackgroundResource ( R.drawable.rock)
                    1 -> enemyHand.setBackgroundResource ( R.drawable.scissors)
                    2 -> enemyHand.setBackgroundResource ( R.drawable.paper)
                }

                val gameResult = (cpHand - myHand + 3) % 3

                when (gameResult) {
                    0 -> textView.text = "You drow"
                    1 -> textView.text = "You win!"
                    2 -> textView.text = "You lose"
                }
            } else {
                handler.postDelayed(runnable, 50)
                textView.text = "janken..."
            }
        }
        handler.post(runnable)
    }
    fun fadeout(hand: handType, cpHand:Int) {
        val fadeInAnimation = AlphaAnimation (0.0f, 1.0f)
        val fadeOutAnimation = AlphaAnimation (1.0f,0.0f)

        fadeInAnimation.duration = 100
        fadeInAnimation.fillAfter = true
        fadeOutAnimation.duration = 100
        fadeOutAnimation.fillAfter = true
    }
}
