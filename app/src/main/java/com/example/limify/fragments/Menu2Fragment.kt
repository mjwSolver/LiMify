package com.example.limify01

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.limify.PemasukanActivity
import com.example.limify.R
import com.example.limify.databinding.FragmentMenu2Binding


class Menu2Fragment : Fragment() {

    private lateinit var viewBind: FragmentMenu2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBind = FragmentMenu2Binding.inflate(layoutInflater, container, false)
        setupSpinner()
        viewBind.textView5.setOnClickListener{
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
            startActivity(Intent(context, PemasukanActivity::class.java))
        }

        return viewBind.root
    }




    private fun setupSpinner() {
        val personNames =  arrayOf("Kebutuhan Pokok", "Keinginan Pribadi")
        val spinner = viewBind.spinner
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, personNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.selected_item) + " " + personNames[position],
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }
    }



}