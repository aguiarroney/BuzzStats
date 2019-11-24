package com.example.buzzstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusBtn : Button = findViewById(R.id.plus_btn)

        plusBtn.setOnClickListener {
            somaContador()
        }
    }

    private fun somaContador(){
        val qntAtualEditText : TextView  = findViewById(R.id.contador)
        val qntAtualInt = qntAtualEditText.text.toString().toInt()
        val soma = qntAtualInt + 1
        qntAtualEditText.text = soma.toString()
    }
}
