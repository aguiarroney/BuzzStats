package com.example.buzzstats

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.buzzstats.databinding.ContadorFragmentLayoutBinding
import kotlinx.android.synthetic.main.contador_fragment_layout.*

const val CONTADOR = "contador"

class ContadorFragment : Fragment() {

    private lateinit var binding: ContadorFragmentLayoutBinding

    //used for when there's a rotation on the screen
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(null != savedInstanceState){
            binding.contador.text = savedInstanceState.getString(CONTADOR)
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = DataBindingUtil.inflate(inflater, R.layout.contador_fragment_layout, container, false)

        binding.plusFab.setOnClickListener {
            modifyContador(1)
        }

        binding.minusFab.setOnClickListener {
            modifyContador(2)
        }

        binding.fecharContaBtn.setOnClickListener {view : View ->
            view.findNavController().navigate(ContadorFragmentDirections.fromContadorToFinal(binding.contador.text.toString()))
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
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

    //used for when there's a rotation on the screen
    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString(CONTADOR, binding.contador.text.toString())
    }
}