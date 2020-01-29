package com.example.buzzstats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.buzzstats.databinding.AboutLayoutBinding
import com.example.buzzstats.databinding.ActivityMainBinding

class AboutFragment : Fragment(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.about_layout, container, false)
    }
}