package com.example.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isFragment: Boolean = false
        val fragmentManager = supportFragmentManager

        button.setOnClickListener() {
            if (isFragment == false) {
                val fragmentTransaction = fragmentManager.beginTransaction()

                fragmentTransaction.add(R.id.container, FirstFragment(), "test")
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
                isFragment = true
            } else {
                val fragmentTransaction = fragmentManager.beginTransaction()

                fragmentManager.findFragmentByTag("test")?.let{
                    fragmentTransaction.remove(it)
                }

                fragmentTransaction.commit()
                isFragment = false
            }
        }

    }
}