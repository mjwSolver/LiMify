package com.example.limify

import Database.GlobalVar.Companion.luaran
import Database.GlobalVar.Companion.masukan
import Database.GlobalVar.Companion.monthing
import Database.GlobalVar.Companion.needing
import Database.GlobalVar.Companion.saving
import Database.GlobalVar.Companion.wanting
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.limify.databinding.ActivityRencanaBinding

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

                val intenting = Intent(this, BottomnavbarActivity::class.java)
                startActivity(intenting)
                finish()

            }
        }




    }





}