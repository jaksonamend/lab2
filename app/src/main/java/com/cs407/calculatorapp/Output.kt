package com.cs407.calculatorapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Output : AppCompatActivity() {

    lateinit var output : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_output)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val message = intent.getIntExtra("result", -1)
        val errorMessage = intent.getStringExtra("errorMessage")
        // get data using intent
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        if(errorMessage != null){
            resultTextView.text = errorMessage.toString()
        }
        else{
            resultTextView.text = message.toString()
        }
    }
}