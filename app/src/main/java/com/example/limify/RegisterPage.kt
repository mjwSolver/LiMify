package com.example.limify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.limify01.databinding.ActivityRegisterPageBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterPage : AppCompatActivity() {

    private lateinit var bind:ActivityRegisterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(bind.root)


        val userId = intent.getStringExtra( "user_id")
        val passId = intent.getStringExtra( "pass_id")

        bind.usernameTextView.text = "User ID :: $userId"
        bind.passwordTextView.text = "Password ID :: $passId"

        bind.backButton.setOnClickListener {
            // Logout from app.
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }




    }


}