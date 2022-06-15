package com.example.limify01

import Database.GlobalVar
import Model.Keuangan
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.limify.BottomnavbarActivity
import com.example.limify.PemasukanActivity
import com.example.limify.R
import com.example.limify.databinding.FragmentMenu2Binding
import java.text.SimpleDateFormat
import java.util.*


class Menu2Fragment : Fragment() {
    var adone = false
    var edone = false

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

        column()
        listener()

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


    private fun listener(){
        viewBind.pengeluaran.addTextChangedListener(){
            var pengeluaranBox = viewBind.pengeluaranbox.editText?.text.toString().trim()
            var a=false
            var b=false

            if (pengeluaranBox.isEmpty()){
                b=true
                viewBind.pengeluaran.error = "Tolong isi pengeluaran anda!"
            }
            if (a==false && b==false){

                adone = true
                column()
            }
            viewBind.catatanuser.editText?.addTextChangedListener {
                var name = viewBind.catatanuser.editText?.text.toString().trim()
                if (name.isEmpty()) {
                    viewBind.catatanuser.error = "Tolong isi catatan!"
                    edone = false
                    column()
                } else {
                    viewBind.catatanuser.error = ""
                    edone = true
                    column()
                }
            }
            viewBind.button.setOnClickListener {
                val pengeluaran = viewBind.pengeluaranbox.editText?.text.toString().trim()
                val catatan = viewBind.catatanuser.editText?.text.toString().trim()
                val mySpinner = viewBind.spinner
                val text = mySpinner.selectedItem.toString()
                val tipe="Pengeluaran"
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())

                var tes: Keuangan = Keuangan(pengeluaran,catatan,tipe,text,currentDate,GlobalVar.uid)


                GlobalVar.listDataKeuangan.add(tes)

                Toast.makeText(context, "Data sukses disimpan!", Toast.LENGTH_LONG).show()
                val intent = Intent(context, BottomnavbarActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun column() {
        if (adone && edone) {
            viewBind.button.isEnabled = true
        } else {
            viewBind.button.isEnabled = false
        }
    }

}