package com.example.limify

import Database.GlobalVar.Companion.emailUser
import Database.GlobalVar.Companion.passUser
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.limify.databinding.ActivitySettingsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth


class SettingsActivity : AppCompatActivity() {

    private lateinit var bind:ActivitySettingsBinding
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.changePlansButton.setOnClickListener{
            val intenting = Intent(this, rencanaanActivity::class.java)
            startActivity(intenting)
        }

        bind.settingsBackButton.setOnClickListener{
            finish()
        }

        bind.signOutButton.setOnClickListener{

            val shareEditor: SharedPreferences.Editor = pref.edit()
            shareEditor.remove("shared")
            shareEditor.apply()

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginPage::class.java))
            finish()

        }


        bind.deleteMyAccountButton.setOnClickListener{

            MaterialAlertDialogBuilder(this)
                .setTitle("Deleting your Account")
                .setMessage("Are you sure you want to erase your account? this can't be undone.")
                .setNegativeButton("Nevermind") { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton("Yes, delete my account") { dialog, which ->

                    var user = FirebaseAuth.getInstance().getCurrentUser();
                    val credential = EmailAuthProvider.getCredential(emailUser, passUser)

                    user?.reauthenticate(credential)?.addOnCompleteListener {
                        user.delete().addOnCompleteListener { task ->
                            if (task.isSuccessful) {

                                val shareEditor: SharedPreferences.Editor = pref.edit()
                                shareEditor.clear().apply()

                                Log.d("TAG", "User account deleted.")
                                startActivity(Intent(this@SettingsActivity,
                                    LoginPage::class.java))
                                finish()
                                Toast.makeText(this@SettingsActivity,
                                    "User Deleted Successfully", Toast.LENGTH_LONG ).show()
                            }
                        }
                    }
                }
                .show()







        }



    }




}