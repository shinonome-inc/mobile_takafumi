package com.example.leapyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            var isValid = true
            val editText = findViewById<EditText>(R.id.editText)

            if(editText.text.isEmpty()){
                editText.error = getString(R.string.EditText_error)
                isValid = false
            }

           if (isValid) {
               val year = editText.text.toString().toInt()

               if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                   textView.text = "$year is leap year"
               } else{
                   textView.text = "$year is not leap year"
               }
           }
        }
    }
}
