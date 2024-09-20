package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            val additionButton = findViewById<Button>(R.id.additionButton)
            val subtractionButton = findViewById<Button>(R.id.subtractionButton)
            val multiplicationButton = findViewById<Button>(R.id.multiplicationButton)
            val divisionButton = findViewById<Button>(R.id.divisionButton)
            val userInput1 = findViewById<EditText>(R.id.editTextNumber2)
            val userInput2 = findViewById<EditText>(R.id.editTextNumber3)

            additionButton.setOnClickListener{
                val input1 = userInput1.text.toString().toInt()
                val input2 = userInput2.text.toString().toInt()
                val result = input1 + input2
                val intent = Intent(this@MainActivity, Output::class.java)

                intent.putExtra("result", result)
                startActivity(intent)
            }

            subtractionButton.setOnClickListener{
                val input1 = userInput1.text.toString().toInt()
                val input2 = userInput2.text.toString().toInt()
                val result = input1 - input2
                val intent = Intent(this@MainActivity, Output::class.java)

                intent.putExtra("result", result)
                startActivity(intent)
            }

            multiplicationButton.setOnClickListener{
                val input1 = userInput1.text.toString().toInt()
                val input2 = userInput2.text.toString().toInt()
                val result = input1 * input2
                val intent = Intent(this@MainActivity, Output::class.java)

                intent.putExtra("result", result)
                startActivity(intent)
            }

            divisionButton.setOnClickListener{
                val input1 = userInput1.text.toString().toInt()
                val input2 = userInput2.text.toString().toInt()
                if (input2 != 0 ){
                    val result = input1 / input2
                    val intent = Intent(this@MainActivity, Output::class.java)

                    intent.putExtra("result", result)
                    startActivity(intent)
                }
                else {
                    val errorMessage = "Cannot divide by 0!"
                    val intent = Intent(this@MainActivity, Output::class.java)
                    intent.putExtra("errorMessage", errorMessage)
                    startActivity(intent)
                }
            }
    }
}