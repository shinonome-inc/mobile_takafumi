package com.example.kadai03

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text1: TextView = findViewById(R.id.text)
        var checktext: TextView = findViewById(R.id.textView2)
        var button: Button = findViewById(R.id.button)

        checktext.x
        button.setOnClickListener {
            text1.x
        }
    }

    fun hantei(x: Int): Int {
        if (x % 400 == 0) {
            println("閏年です")
        } else if (x % 100 == 0) {
            println("閏年ではありません")
        } else if (x % 4 == 0) {
            println("閏年です")
        } else {
            println("閏年ではありません")
        }
        return x
    }

    fun main() {
        println("閏年判定プログラム")

        print("西暦を入力してください")

        val x = readLine()?.toInt()
        var v = 0
        if (x != null) {
            hantei(x)
        }
    }
}
