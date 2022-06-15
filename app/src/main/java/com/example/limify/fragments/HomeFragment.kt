package com.example.limify.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.limify.databinding.FragmentCalendarBinding
import com.example.limify.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var frag: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        frag = FragmentHomeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        
        return frag.root
    }

}