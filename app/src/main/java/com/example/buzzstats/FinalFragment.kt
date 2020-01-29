package com.example.buzzstats

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.buzzstats.databinding.FinalFragmentLayoutBinding

class FinalFragment : Fragment(){

    private lateinit var binding : FinalFragmentLayoutBinding
    private lateinit var args : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.final_fragment_layout, container, false)

        args = setContadorText()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setContadorText() : String {
        var args = FinalFragmentArgs.fromBundle(arguments!!).contadorConsumo
        binding.finalContador.text = args
        return args
    }

    private fun getShareIntet(args : String) : Intent{

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, "BuzzStats: \n" + getString(R.string.consumo_string) + " " +args)
        return shareIntent
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId){
            R.id.share_menu_id -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }
    private fun shareSuccess(){
        startActivity(getShareIntet(args))
    }
}