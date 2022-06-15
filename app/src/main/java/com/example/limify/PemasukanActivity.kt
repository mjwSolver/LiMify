package com.example.limify


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.limify.R
import com.example.limify.databinding.ActivityPemasukanBinding


class PemasukanActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityPemasukanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemasukan)
        viewBind = ActivityPemasukanBinding.inflate(layoutInflater)
        val view = viewBind.root

        setContentView(view)

        setupSpinner()
        val pengeluaran = findViewById<TextView>(R.id.textView6)
        pengeluaran.setOnClickListener{
            finish()
        }
    }
    private fun setupSpinner() {
        val personNames =  arrayOf("Kebutuhan Pokok", "Keinginan Pribadi")
        val spinner = viewBind.spinner
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@PemasukanActivity,
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