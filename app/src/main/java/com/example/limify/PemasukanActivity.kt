package com.example.limify


import Database.GlobalVar
import Model.Keuangan
import Model.KeuanganHarian
import Model.PengeluaranHarian
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.limify.databinding.ActivityPemasukanBinding
import java.text.SimpleDateFormat
import java.util.*


class PemasukanActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityPemasukanBinding
    var adone = false
    var edone = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemasukan)
        viewBind = ActivityPemasukanBinding.inflate(layoutInflater)
        val view = viewBind.root

        setContentView(view)
        column()
        listener()
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
    private fun listener(){
        viewBind.pemasukkan.addTextChangedListener(){
            var pengeluaranBox = viewBind.pemasukkanbox.editText?.text.toString().trim()
            var a=false
            var b=false

            if (pengeluaranBox.isEmpty()){
                b=true
                viewBind.pemasukkan.error = "Tolong isi pengeluaran anda!"
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
                val pengeluaran = viewBind.pemasukkanbox.editText?.text.toString().trim()
                val catatan = viewBind.catatanuser.editText?.text.toString().trim()
                val mySpinner = viewBind.spinner
                val text = mySpinner.selectedItem.toString()
                val tipe="pemasukan"
                val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                val currentDate = sdf.format(Date())
                val adf = SimpleDateFormat("dd/M/yyyy")
                val currentDat = adf.format(Date())
                var tes: Keuangan = Keuangan(pengeluaran,catatan,tipe,text,currentDate,GlobalVar.uid)
                var test: KeuanganHarian = KeuanganHarian(pengeluaran,text,currentDat,GlobalVar.uid)
                var temp = PengeluaranHarian(tipe)
                temp.addParent(test)
                GlobalVar.listDataKeluarHarian.add(temp)
                GlobalVar.listDataKeuangan.add(tes)

                Toast.makeText(this, "Data sukses disimpan!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, BottomnavbarActivity::class.java)
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