package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var AnimationDrawable = AnimationDrawable()
        var frame1 = ResourcesCompat.getDrawable ( resources,R.drawable.rock,null )
        var frame2 = ResourcesCompat.getDrawable ( resources,R.drawable.scissors,null )
        var frame3 = ResourcesCompat.getDrawable ( resources,R.drawable.paper,null )

        if (frame1 != null) {
            AnimationDrawable.addFrame ( frame1,50 )
        }
        if ( frame2 != null ) {
            AnimationDrawable.addFrame ( frame2,50 )
        }
        if ( frame3 != null ) {
            AnimationDrawable.addFrame (frame3,50 )
        }

        enemyHand.background = AnimationDrawable
        AnimationDrawable.start()

        rock.setOnClickListener { onJankenBottonTapped ( it )}
        scissors.setOnClickListener { onJankenBottonTapped ( it ) }
        paper.setOnClickListener { onJankenBottonTapped ( it ) }

    }

    fun onJankenBottonTapped( view: View? ) {
        val intent = Intent( this, ResultActiviity::class.java )
        intent.putExtra("myHand", view?.id)
        startActivity( intent )
    }
}

