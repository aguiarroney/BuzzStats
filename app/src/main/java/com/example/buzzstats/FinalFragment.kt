package com.example.buzzstats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.buzzstats.databinding.FinalFragmentLayoutBinding

class FinalFragment : Fragment(){

    private lateinit var binding : FinalFragmentLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.final_fragment_layout, container, false)

        var ars = FinalFragmentArgs.fromBundle(arguments!!)

        binding.finalContador.text = ars.contadorConsumo

        return binding.root
    }
}