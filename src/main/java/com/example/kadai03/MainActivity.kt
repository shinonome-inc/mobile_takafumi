package com.example.kadai03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {

            var isValid = true

            val message =findViewById<TextView>(R.id.message)
            val editTextNumber =  findViewById<TextView>(R.id.editTextNumber)
            val EditText = editTextNumber.text

            if(EditText.isEmpty()){
                message.error = "西暦を入力してね"
                isValid = false
            }

            if(isValid){
                val toshi = Integer.parseInt(EditText as String)
                if(toshi % 400 == 0){
                    val set_kekka = findViewById<TextView>(R.id.message)
                    set_kekka.text = "true"
                }else if(toshi % 100 == 0){
                    val set_kekka = findViewById<TextView>(R.id.message)
                    set_kekka.text = "false"
                }else if(toshi % 4 == 0){
                    val set_kekka = findViewById<TextView>(R.id.message)
                    set_kekka.text = "true"
                }else{
                    val set_kekka = findViewById<TextView>(R.id.message)
                    set_kekka.text = "false"
                }

            }


        }
    }
}