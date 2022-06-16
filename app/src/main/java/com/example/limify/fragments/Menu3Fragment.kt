package com.example.limify01

import Database.GlobalVar
import Interface.CardListener
import Model.HistoryRecycle
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limify.databinding.FragmentMenu3Binding
import com.example.limify01.Adapter.ListDataAdapter



class Menu3Fragment : Fragment(),CardListener {

    private lateinit var viewBind: FragmentMenu3Binding
    private val adapter = ListDataAdapter(GlobalVar.listHistoryRecycle, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBind = FragmentMenu3Binding.inflate(layoutInflater, container, false)

        setupRecyclerView()

        showFirst()
        return viewBind.root
    }

    private fun setupRecyclerView(){

        val layoutManager = LinearLayoutManager(requireActivity().baseContext)
        viewBind.lvHistoryView.layoutManager = layoutManager
        viewBind.lvHistoryView.adapter=adapter// Set layout
    }
    private fun showFirst(){
        var a=0


        for (x in 0..GlobalVar.listDataKeuangan.size-1){
            val jangka="alltime"

            val temp = HistoryRecycle(jangka,a)
            a++
            temp.addParent(GlobalVar.listDataKeuangan.get(x))

            GlobalVar.listHistoryRecycle.add(temp)

        }
        adapter.notifyDataSetChanged()
    }
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }


    override fun onCardClick(position: Int) {


    }
}


