package com.example.limify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.limify.databinding.ActivityRegisterPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterPage : AppCompatActivity() {

    private lateinit var bind:ActivityRegisterPageBinding
    private lateinit var userID:String
    private lateinit var passID:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(bind.root)

        registerListener()
        allListeners()

    } // end of On Create


    fun registerListener() {

        bind.RegisterButton.setOnClickListener{

            var aemail = bind.emailTextInputLayout.editText?.text.toString().trim()
//            var ausername = bind.usernameTextInputLayout.editText?.text.toString().trim()
            var apassword = bind.passwordTextInputLayout.editText?.text.toString().trim()

            if(apassword.isEmpty() || aemail.isEmpty()) {
//            if(ausername.isEmpty() || apassword.isEmpty() || aemail.isEmpty()) {
//                TextUtils.isEmpty(
//                    bind.usernameTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
//                    Toast.makeText(this@RegisterPage, "Please enter username.", Toast.LENGTH_SHORT).show()
//                }

                TextUtils.isEmpty(
                    bind.passwordTextInputLayout.editText?.text.toString().trim { it <= ' ' }).apply {
                    Toast.makeText(this@RegisterPage, "Please enter password.", Toast.LENGTH_SHORT)
                        .show()
                }

                TextUtils.isEmpty(
                    bind.emailTextInputLayout.editText?.text.toString().trim { it <= ' ' }).apply {
                    Toast.makeText(this@RegisterPage, "Please enter email.", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                val theBase = FirebaseAuth.getInstance()
                val email: String = aemail
                val password: String = apassword

                theBase.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!

                        Toast.makeText(
                            this, "Successfully Registered", Toast.LENGTH_SHORT
                        ).show()

                        val intent = Intent(this, LoginPage::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

    } // end of RegisterListener

    fun allListeners() {
        bind.backButton.setOnClickListener {
            // Logout from app.
//            FirebaseAuth.getInstance().signOut()
//            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }

    }


}