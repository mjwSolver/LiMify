package com.example.limify

import Database.GlobalVar
import Database.GlobalVar.Companion.luaran
import Database.GlobalVar.Companion.masukan
import Database.GlobalVar.Companion.monthing
import Database.GlobalVar.Companion.needing
import Database.GlobalVar.Companion.saving
import Database.GlobalVar.Companion.wanting
import Model.Bulanan
import Model.Keuangan
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.limify.databinding.ActivityRencanaBinding
import java.text.SimpleDateFormat
import java.util.*

class RencanaActivity : AppCompatActivity() {

//    lateinit var shared: SharedPreferences
    private lateinit var bind:ActivityRencanaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRencanaBinding.inflate(layoutInflater)
        setContentView(bind.root)
//        The last one that will get the grade.

        var month = bind.defaultMonthlyCheckBoxan.isChecked
        var masuk = bind.masukPerBulanTextInputLayout.editText?.text.toString().trim()
        var luar = bind.pengeluaranSudahTextInputLayout.editText?.text.toString().trim()
//        var needs = bind.needTextInputLayout.editText?.text.toString().trim()
//        var wants = bind.wantsTextInputLayout.editText?.text.toString().trim()
//        var savings = bind.savingsTextInputLayout.editText?.text.toString().trim()


        bind.saveButton.setOnClickListener {

//            replaced with individual whens.
//            if (needs.isEmpty()) {
//                Toast.makeText(
//                    this@RencanaActivity,
//                    "Please enter amount for needs.",
//                    Toast.LENGTH_SHORT
//                ).show()
////            fill1 = false
//            } else if (wants.isEmpty()) {
//                Toast.makeText(
//                    this@RencanaActivity,
//                    "Please enter amount for wants.",
//                    Toast.LENGTH_SHORT
//                ).show()
////            fill2 = false
//            } else if (savings.isEmpty()) {
//                Toast.makeText(
//                    this@RencanaActivity,
//                    "Please enter amount of savings.",
//                    Toast.LENGTH_SHORT
//                ).show()
////            fill3 = false
//            } else
                if (bind.masukPerBulanTextInputLayout.editText?.text.toString().isEmpty()) {
                Toast.makeText(
                    this@RencanaActivity,
                    "Harap mengisi pemasukan per bulannya",
                    Toast.LENGTH_SHORT
                ).show()
//            fill4 = false
            } else
                if (bind.pengeluaranSudahTextInputLayout.editText?.text.toString().isEmpty()) {
                Toast.makeText(
                    this@RencanaActivity,
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

                monthing = month
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
                    GlobalVar.listDataBulanan.add(tes)
                val intenting = Intent(this, BottomnavbarActivity::class.java)
                startActivity(intenting)
                finish()

            }
        }




    }





}