package com.example.limify

import Database.GlobalVar
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
import com.example.limify.databinding.ActivityRencanaanBinding

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

            if(needs.isEmpty() || wants.isEmpty() || savings.isEmpty() || masuk.isEmpty() || luar.isEmpty()){
                TextUtils.isEmpty(
                    bind.needTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@rencanaanActivity, "Please enter amount for needs.", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(
                    bind.wantsTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@rencanaanActivity, "Please enter amount for wants.", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(
                    bind.savingsTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@rencanaanActivity, "Please enter amount of savings.", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(
                    bind.masukPerBulanTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@rencanaanActivity, "Harap mengisi pemasukan per bulannya", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(
                    bind.pengeluaranSudahTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@rencanaanActivity, "Harap mengisi pengeluaran selama bulan ini", Toast.LENGTH_SHORT).show()
                }
            } else if(needs.toInt() + wants.toInt() + savings.toInt() != 100) {

                if ( needs.toInt() + wants.toInt() + savings.toInt() > 100) {
                    Toast.makeText(this@rencanaanActivity, "You've exceeded 100% limit, please reconfigure", Toast.LENGTH_LONG).show()
                } else if (needs.toInt() + wants.toInt() + savings.toInt() < 100) {
                    Toast.makeText(this@rencanaanActivity, "Your final percentage isn't 100%", Toast.LENGTH_LONG).show()
                }

            } else {

                val sharedEditor: SharedPreferences.Editor = shared.edit()
                sharedEditor.putString("masuk", masuk)
                    .putString("luar", luar)
                    .putString("needs", needs)
                    .putString("wants", wants)
                    .putString("savings", savings)
                    .apply()

                GlobalVar.masukan = masuk
                GlobalVar.luaran = luar

                GlobalVar.needing = needs
                GlobalVar.wanting = wants
                GlobalVar.saving = savings

                GlobalVar.monthing = monthing

                val intenting = Intent(this, SettingsActivity::class.java)
                startActivity(intenting)
                finish()
            }
        }
    }




}