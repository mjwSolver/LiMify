package com.example.limify

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.limify.databinding.ActivityRandomRedirectBinding
import com.google.firebase.auth.FirebaseAuth

class randomRedirect : AppCompatActivity() {

    private lateinit var bind: ActivityRandomRedirectBinding
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRandomRedirectBinding.inflate(layoutInflater)
        setContentView(bind.root)

        pref = getSharedPreferences("shared", Context.MODE_PRIVATE)

        val name = pref.getString("username", "")
        bind.emailTextView.setText(name)
        val pass = pref.getString("password", "")
        bind.passwordTextView.setText(pass)

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