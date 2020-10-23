package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    enum class handType(val n: Int) {
        gu(0),
        choki(1),
        pa(2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            enemyHand.setImageResource(R.drawable.rock)

        rock.setOnClickListener {
            fadeBotton (rock)
            janken(handType.gu)
        }

        scissors.setOnClickListener {
            fadeBotton (scissors)
            janken(handType.choki)
        }

        paper.setOnClickListener {
            fadeBotton (paper)
            janken(handType.pa)
        }

    }

    fun janken(hand: handType) {
        val myHand: Int = hand.n
        val cpHand = (Math.random() * 3).toInt()
        val handler = Handler()
        var runnable = Runnable {}
        var i: Int = 0

        rock.isClickable = false
        scissors.isClickable = false
        paper.isClickable = false


        runnable = Runnable {
            i++

            when (i % 3) {
                0 -> enemyHand.setImageResource( R.drawable.rock )
                1 -> enemyHand.setImageResource( R.drawable.scissors )
                2 -> enemyHand.setImageResource( R.drawable.paper )
            }

            if (i >= 30){
                when ( cpHand ) {
                    0 -> enemyHand.setImageResource( R.drawable.rock )
                    1 -> enemyHand.setImageResource( R.drawable.scissors )
                    2 -> enemyHand.setImageResource( R.drawable.paper )
                }

                val gameResult = (cpHand - myHand + 3) % 3

                when (gameResult) {
                    0 -> textView.text = "You drow"
                    1 -> textView.text = "You win!"
                    2 -> textView.text = "You lose"
                }

                rock.isClickable = true
                scissors.isClickable = true
                paper.isClickable = true

            } else {
                handler.postDelayed(runnable, 50)
                textView.text = "janken..."
            }
        }
        handler.post(runnable)
    }

    fun fadeBotton ( imageButton: ImageButton ) {
        val fadeoutAnimation = AlphaAnimation (1.0f,0.0f)
        val fadeinAnimation = AlphaAnimation (0.0f,1.0f)

        fadeoutAnimation.duration = 100
        fadeoutAnimation.fillAfter = true
        imageButton.animation = fadeoutAnimation

        fadeinAnimation.duration = 100
        fadeinAnimation.fillAfter = true
        imageButton.animation = fadeinAnimation
    }
}
