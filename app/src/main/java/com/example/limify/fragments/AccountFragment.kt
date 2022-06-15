package com.example.limify.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.limify.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    private lateinit var frag:FragmentAccountBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle? ): View? {
        frag = FragmentAccountBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment






        return frag.root
    }

}