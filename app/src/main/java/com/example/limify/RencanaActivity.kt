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

    lateinit var shared: SharedPreferences
    private lateinit var bind:ActivityRencanaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRencanaBinding.inflate(layoutInflater)
        setContentView(bind.root)
//        The last one that will get the grade.

        var month = bind.defaultMonthlyCheckBoxan.isChecked
        var masuk = bind.masukPerBulanTextInputLayout.editText?.text.toString().trim()
        var luar = bind.pengeluaranSudahTextInputLayout.editText?.text.toString().trim()
        var needs = bind.needTextInputLayout.editText?.text.toString().trim()
        var wants = bind.wantsTextInputLayout.editText?.text.toString().trim()
        var savings = bind.savingsTextInputLayout.editText?.text.toString().trim()

        bind.saveButton.setOnClickListener{

//            replaced with individual whens.
//            if(needs.isEmpty() || wants.isEmpty() || savings.isEmpty() || masuk.isEmpty() || luar.isEmpty()){
//                TextUtils.isEmpty(
//                    bind.needTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
//                    Toast.makeText(this@RencanaActivity, "Please enter amount for needs.", Toast.LENGTH_SHORT).show()
//                }
//                TextUtils.isEmpty(
//                    bind.wantsTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
//                    Toast.makeText(this@RencanaActivity, "Please enter amount for wants.", Toast.LENGTH_SHORT).show()
//                }
//                TextUtils.isEmpty(
//                    bind.savingsTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
//                    Toast.makeText(this@RencanaActivity, "Please enter amount of savings.", Toast.LENGTH_SHORT).show()
//                }
//                TextUtils.isEmpty(
//                    bind.masukPerBulanTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
//                    Toast.makeText(this@RencanaActivity, "Harap mengisi pemasukan per bulannya", Toast.LENGTH_SHORT).show()
//                }
//                TextUtils.isEmpty(
//                    bind.pengeluaranSudahTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
//                    Toast.makeText(this@RencanaActivity, "Harap mengisi pengeluaran selama bulan ini", Toast.LENGTH_SHORT).show()
//                }
//            } else
                if(needs.toInt() + wants.toInt() + savings.toInt() != 100) {

                    if ( needs.toInt() + wants.toInt() + savings.toInt() > 100) {
                        Toast.makeText(this@RencanaActivity, "You've exceeded 100% limit, please reconfigure", Toast.LENGTH_LONG).show()
                    } else if (needs.toInt() + wants.toInt() + savings.toInt() < 100) {
                        Toast.makeText(this@RencanaActivity, "Your final percentage isn't 100%", Toast.LENGTH_LONG).show()
                    }

            } else {

                val sharedEditor: SharedPreferences.Editor = shared.edit()
                sharedEditor.putString("masuk", masuk)
                    .putString("luar", luar)
                    .putString("needs", needs)
                    .putString("wants", wants)
                    .putString("savings", savings)
                    .putBoolean("monthly", month)
                    .apply()

                masukan = masuk
                luaran = luar

                needing = needs
                wanting = wants
                saving = savings

                monthing = month

                val intenting = Intent(this, MainActivity::class.java)
                startActivity(intenting)
                finish()
            }


        }


    }





}