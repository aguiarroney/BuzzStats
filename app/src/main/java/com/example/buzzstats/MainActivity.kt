package com.example.buzzstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusFab : FloatingActionButton = findViewById(R.id.plus_fab)
        val minusFab : FloatingActionButton = findViewById(R.id.minus_fab)

        plusFab.setOnClickListener {
            modifyContador(1)
        }

        minusFab.setOnClickListener {
            modifyContador(2)
        }
    }

    private fun modifyContador(operador : Int){
        var soma: Int
        val qntAtualTextView: TextView  = findViewById(R.id.contador)
        var qntAtualText = qntAtualTextView.text

        if(qntAtualText.isEmpty())
            qntAtualText = "0"


        println("[LOG: MainActivity] TextView Value: "+qntAtualText)


        if(operador == 1){
            soma = qntAtualText.toString().toInt() + 1
        }

        else if(operador == 2 && qntAtualText.toString().toInt()>0){
            soma = qntAtualText.toString().toInt() - 1
        }

        else{
            soma = qntAtualText.toString().toInt()
        }

        qntAtualTextView.text = soma.toString()

    }
}
