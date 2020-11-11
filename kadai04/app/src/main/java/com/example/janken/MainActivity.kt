package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enemyHand.setImageResource(R.drawable.paper)

        rock.setOnClickListener {
            fadeButton(rock)
            janken(HandType.gu)
        }

        scissors.setOnClickListener {
            fadeButton(scissors)
            janken(HandType.choki)
        }

        paper.setOnClickListener {
            fadeButton(paper)
            janken(HandType.pa)
        }

    }

    fun janken (hand: HandType) {
        val randomValue = ( Math.random() * 3 ).toInt()
        val cpHand = HandType.values().first { it.n == randomValue }
        val handler = Handler()
        var runnable = Runnable {}
        var i: Int = 0

        rock.isClickable = false
        scissors.isClickable = false
        paper.isClickable = false


        runnable = Runnable {
            i++

            when (HandType.values().first { it.n == i % 3 }) {
                HandType.gu -> enemyHand.setImageResource(R.drawable.rock)
                HandType.choki -> enemyHand.setImageResource(R.drawable.scissors)
                HandType.pa -> enemyHand.setImageResource(R.drawable.paper)
            }

            if (i >= 30){

                when (cpHand) {
                    HandType.gu -> enemyHand.setImageResource(R.drawable.rock)
                    HandType.choki -> enemyHand.setImageResource(R.drawable.scissors)
                    HandType.pa -> enemyHand.setImageResource(R.drawable.paper)
                }

                val gameResult = JankenResult.values().first { it.n == (cpHand.n - hand.n + 3) % 3 }

                when (gameResult) {
                    JankenResult.draw -> textView.text = "You drow"
                    JankenResult.win -> textView.text = "You win!"
                    JankenResult.lose -> textView.text = "You lose"
                }

                rock.isClickable = true
                scissors.isClickable = true
                paper.isClickable = true

            } else {
                handler.postDelayed (runnable, 50)
                textView.text = "janken..."
            }
        }
        handler.post (runnable)
    }

    fun fadeButton (handButton: ImageButton) {
        val fadeOutAnimation = AlphaAnimation (1.0f,0.0f)
        val fadeInAnimation = AlphaAnimation (0.0f,1.0f)

        fadeOutAnimation.duration = 1000
        fadeOutAnimation.fillAfter = true
        handButton.animation = fadeOutAnimation

        fadeInAnimation.duration = 100
        fadeInAnimation.fillAfter = true
        handButton.animation = fadeInAnimation
    }
}

enum class HandType(val n: Int) {
    gu(0),
    choki(1),
    pa(2)
}

enum class JankenResult (val n:Int) {
    draw(0),
    win(1),
    lose(2)
}
