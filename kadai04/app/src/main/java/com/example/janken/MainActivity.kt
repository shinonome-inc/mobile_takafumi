package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad = AnimationDrawable()
        var frame1 = resources.getDrawable(R.drawable.rock)
        var frame2 = resources.getDrawable(R.drawable.scissors)
        var frame3 = resources.getDrawable(R.drawable.paper)

        ad.addFrame(frame1,50)
        ad.addFrame(frame2,50)
        ad.addFrame(frame3,50)
        imageView.background = ad
        ad.start()


        rock.setOnClickListener{
            janken(HandType.rock)
            ad.stop()
        }

        scissors.setOnClickListener{
            janken(HandType.scissors)
            ad.stop()
        }

        paper.setOnClickListener{
            janken(HandType.paper)
            ad.stop()
        }
    }

    enum class HandType(val n:Int){
        rock(1),
        scissors(2),
        paper(3)
    }

    fun janken(hand : HandType){
        val r = Random.nextInt(3)
        val enemyHand:Int
        val myHand:Int=hand.n

        if (r == 0) {
            enemyHand = HandType.rock.n
            imageView.setImageResource(R.drawable.rock)
        } else if (r == 1) {
            enemyHand = HandType.scissors.n
            imageView.setImageResource(R.drawable.scissors)
        } else{
            enemyHand = HandType.paper.n
            imageView.setImageResource(R.drawable.paper)
        }
        when{
            enemyHand == myHand ->{
                textView.text = "You Drow"
            }

            ((enemyHand == 1) && (myHand==3)) || ((enemyHand == 2) && (myHand == 1)) || ((enemyHand == 3) && (myHand == 2)) ->{
                textView.text = "You Win!"
            }

            else ->{
                textView.text = "You Lose.."
            }
        }
    }
}
