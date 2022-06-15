package com.example.limify

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.TextUtils
import android.widget.Toast
import com.example.limify.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.

class LoginPage : AppCompatActivity() {

    lateinit var shared: SharedPreferences
    private lateinit var bind:ActivityLoginPageBinding
    var remember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(bind.root)

        checkRemember()
        listeners()

        bind.signInButton.setOnClickListener {

            var ausername = bind.usernameTextInputLayout.editText?.text.toString().trim()
            var apassword = bind.passwordTextInputLayout.editText?.text.toString().trim()

            if(ausername.isEmpty() || apassword.isEmpty()) {
                TextUtils.isEmpty(
                    bind.usernameTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@LoginPage, "Please enter username.", Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(
                    bind.passwordTextInputLayout.editText?.text.toString().trim { it <= ' ' }).apply {
                    Toast.makeText(this@LoginPage, "Please enter password.", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                val theBase = FirebaseAuth.getInstance()
                val username: String = ausername
                val password: String = apassword

                theBase.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener { mTask ->
                        if (mTask.isSuccessful) {

                            val rbutton = bind.rememberMeCheckBox.isChecked
                            val sharedEditor: SharedPreferences.Editor = shared.edit()
                            sharedEditor.putString("username", username)
                                .putString("password", password)
                                .putBoolean("remember", rbutton)
                                .apply()

                            Toast.makeText(this, "Signed In Successfully", Toast.LENGTH_SHORT).show()
                            val intent =
//                                Intent(this, MainActivity::class.java).apply {
                                Intent(this, randomRedirect::class.java).apply {
//                                    putExtra("user_id", "You're in")
//                                    putExtra("pass_id", password)
                                }
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this, mTask.exception!!.message.toString(), Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }
            }
    } // end of OnCreate

    fun checkRemember() {
        shared = getSharedPreferences("shared", Context.MODE_PRIVATE)
        remember = shared.getBoolean("remember", false)

        if(remember){
//            val intent = Intent(this, MainActivity::class.java)
            val intent = Intent(this, randomRedirect::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun listeners() {

        bind.RegisterButton.setOnClickListener{
            val i = Intent(this, RegisterPage::class.java)
            startActivity(i)

        }

    }

}  // end of class