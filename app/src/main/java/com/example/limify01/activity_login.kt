package com.example.limify01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.limify01.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class activity_login : AppCompatActivity() {

    private lateinit var bind:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val userId= intent.getStringExtra( "user_id")
        val passId = intent.getStringExtra( "pass_id")

        bind.usernameTextView.text = "User ID :: $userId"
        bind.passwordTextView.text = "Password ID :: $passId"


        bind.logoutButton.setOnClickListener {
            // Logout from app.
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }

    }


}