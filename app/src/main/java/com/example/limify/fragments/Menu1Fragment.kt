package com.example.limify01

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.limify.SettingsActivity
import com.example.limify.databinding.FragmentMenu1Binding



class Menu1Fragment : Fragment() {

    private lateinit var viewBind: FragmentMenu1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBind = FragmentMenu1Binding.inflate(layoutInflater, container, false)

//        viewBind.titleMenu1.text = "Ini menu 1"

        viewBind.settingsButton.setOnClickListener{
            val intenting = Intent(context, SettingsActivity::class.java)
            startActivity(intenting)

        }



        return viewBind.root
    }

}