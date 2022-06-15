package com.example.limify

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder
import com.example.limify.databinding.ActivityRandomRedirectBinding
import com.google.firebase.auth.FirebaseAuth

class randomRedirect : AppCompatActivity() {

    private lateinit var bind: ActivityRandomRedirectBinding
    private lateinit var pref: SharedPreferences
    private lateinit var dialogBuilder: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRandomRedirectBinding.inflate(layoutInflater)
        setContentView(bind.root)

        sharedpref()
        listeners()

    }

    fun sharedpref() {
        pref = getSharedPreferences("shared", Context.MODE_PRIVATE)

        val name = pref.getString("username", "")
        bind.emailTextView.setText(name)
        val pass = pref.getString("password", "")
        bind.passwordTextView.setText(pass)

    }

    fun listeners() {
        bind.redirectButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        bind.logoutButton.setOnClickListener{

            val shareEditor: SharedPreferences.Editor = pref.edit()
            shareEditor.clear()
            shareEditor.apply()

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginPage::class.java))
            finish()

        }


    }



}