package com.example.limify

import Database.GlobalVar
import Database.GlobalVar.Companion.luaran
import Database.GlobalVar.Companion.masukan
import Database.GlobalVar.Companion.monthing
import Database.GlobalVar.Companion.needing
import Database.GlobalVar.Companion.saving
import Database.GlobalVar.Companion.wanting
import Model.Bulanan
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.limify.databinding.ActivityRencanaBinding
import com.example.limify.databinding.ActivityRencanaanBinding
import java.text.SimpleDateFormat
import java.util.*

class rencanaanActivity : AppCompatActivity() {

    private lateinit var bind:ActivityRencanaanBinding
    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRencanaanBinding.inflate(layoutInflater)
        setContentView(bind.root)

        back()
        settingUp()
        saveChanges()



    }

    fun back() { bind.backImageButton.setOnClickListener{   finish()  }  }

    fun settingUp() {

        bind.masukPerBulanTextInputLayout.editText?.setText(masukan)
        bind.pengeluaranSudahTextInputLayout.editText?.setText(luaran)
        bind.needTextInputLayout.editText?.setText(needing)
        bind.wantsTextInputLayout.editText?.setText(wanting)
        bind.savingsTextInputLayout.editText?.setText(saving)
        if (monthing) bind.defaultMonthlyCheckBoxan.isPressed


    }

    fun saveChanges() {

        var masuk = bind.masukPerBulanTextInputLayout.editText?.text.toString().trim()
        var luar = bind.pengeluaranSudahTextInputLayout.editText?.text.toString().trim()
        var needs = bind.needTextInputLayout.editText?.text.toString().trim()
        var wants = bind.wantsTextInputLayout.editText?.text.toString().trim()
        var savings = bind.savingsTextInputLayout.editText?.text.toString().trim()

        bind.saveButton.setOnClickListener{

            if (bind.masukPerBulanTextInputLayout.editText?.text.toString().isEmpty()) {
                Toast.makeText(
                    this@rencanaanActivity,
                    "Harap mengisi pemasukan per bulannya",
                    Toast.LENGTH_SHORT
                ).show()
//            fill4 = false
            } else
                if (bind.pengeluaranSudahTextInputLayout.editText?.text.toString().isEmpty()) {
                    Toast.makeText(
                        this@rencanaanActivity,
                        "Harap mengisi pengeluaran selama bulan ini",
                        Toast.LENGTH_SHORT
                    ).show()
//            fill5 = false
                } else {

//                val sharedEditor: SharedPreferences.Editor = shared.edit()
//                sharedEditor.putString("masuk", masuk)
//                    .putString("luar", luar)
//                    .putString("needs", needs)
//                    .putString("wants", wants)
//                    .putString("savings", savings)
//                    .putBoolean("monthly", month)
//                    .apply()

                    masukan = masuk
                    luaran = luar

//                needing = needs
//                wanting = wants
//                saving = savings


                    var a = bind.masukPerBulanTextInputLayout.editText?.text.toString()
                    var b= a.toLong()
                    var c= bind.pengeluaranSudahTextInputLayout.editText?.text.toString()
                    var d=c.toLong()
                    var e = b-d
                    var kebutuhan = e*0.5
                    var kebutuhan2 = kebutuhan.toString()
                    var keinginan = e*0.3
                    var keinginan2 = keinginan.toString()
                    var investasi = e*0.2
                    var investasi2 = investasi.toString()
                    val adf = SimpleDateFormat("dd/M/yyyy")
                    val currentDat = adf.format(Date())

                    var tes: Bulanan = Bulanan(kebutuhan2,keinginan2,investasi2,currentDat,GlobalVar.uid)
                    var x = GlobalVar.uid
                    for (x in GlobalVar.listDataBulanan){
                        GlobalVar.listDataBulanan.remove(x)
                    }
                    GlobalVar.listDataBulanan.add(tes)
                    val intenting = Intent(this, BottomnavbarActivity::class.java)
                    startActivity(intenting)
                    finish()

                }
        }
    }




}