package com.example.buzzstats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.buzzstats.databinding.ContadorFragmentLayoutBinding

class ContadorFragment : Fragment(){

    private lateinit var binding: ContadorFragmentLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = DataBindingUtil.inflate(inflater, R.layout.contador_fragment_layout, container, false)

        binding.plusFab.setOnClickListener {
            modifyContador(1)
        }

        binding.minusFab.setOnClickListener {
            modifyContador(2)
        }

        return binding.root
    }

    private fun modifyContador(operador : Int){
        var soma: Int
        var contador = binding.contador.text.toString()

        if(contador.isEmpty())
            contador = "0"


        println("[LOG: MainActivity] TextView Value: ${contador}")


        if(operador == 1){
            soma = contador.toInt() + 1
        }

        else if(operador == 2 && contador.toInt()>0){
            soma = contador.toString().toInt() - 1
        }

        else{
            soma = contador.toString().toInt()
        }

        binding.contador.text = soma.toString()

    }
}