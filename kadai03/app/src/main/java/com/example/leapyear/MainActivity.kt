package com.example.leapyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var isValid = true
            val editTextNumber =  findViewById<EditText>(R.id.editText)
            val EditText = editTextNumber.text.toString()

            if(EditText.isEmpty()){
                editTextNumber.error = getString(R.string.EditText_error)
                isValid = false
            }

           if (isValid) {
               val year = Integer.parseInt(EditText)

               if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                   val result = findViewById<TextView>(R.id.textView)
                   result.text = getString(R.string.result, year)
               } else {
                   val result2 = findViewById<TextView>(R.id.textView)
                   result2.text = getString(R.string.result2, year)
               }
           }
        }
    }
}
