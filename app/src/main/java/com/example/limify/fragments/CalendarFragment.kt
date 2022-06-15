package com.example.limify.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.limify.databinding.FragmentAccountBinding
import com.example.limify.databinding.FragmentCalendarBinding


class CalendarFragment : Fragment() {
    private lateinit var frag: FragmentCalendarBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        frag = FragmentCalendarBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment




        return frag.root
    }

}