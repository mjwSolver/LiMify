package com.example.limify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.limify.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.

class LoginPage : AppCompatActivity() {

    private lateinit var bind:ActivityLoginPageBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.signUpButton.setOnClickListener {

            var ausername = bind.usernameTextInputLayout.editText?.text.toString()
            var apassword = bind.passwordTextInputLayout.editText?.text.toString()
                TextUtils.isEmpty(
                    bind.usernameTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                Toast.makeText(this@LoginPage, "Please enter username.", Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(
                    bind.passwordTextInputLayout.editText?.text.toString().trim { it <= ' ' }).apply{
                    Toast.makeText(this@LoginPage, "Please enter password.", Toast.LENGTH_SHORT).show()
                }

//                TextUtils.isEmpty(
//                    bind.passwordTextInputLayout.editText?.text.toString().trim { it <= ' ' }) -> {
//                    Toast.makeText(
//                        this,
//                        "Please enter password.",
//                        Toast.LENGTH_SHORT
//                    ).show()
            if(ausername.isNotEmpty() && apassword.isNotEmpty()) {

                    val theBase = FirebaseAuth.getInstance()
                    val username: String = ausername.trim  { it <= ' ' }
                    val password: String = apassword.trim { it <= ' ' }

                    // Create an instance and create a register a user with email and password.
                    theBase.createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener{ task ->
//                    .addOnCompleteListener(OnCompleteListener<AuthResult> { task ->
                        if (task.isSuccessful) {
                            // Firebase registered user
                            val firebaseUser: FirebaseUser = task.result!!.user!!

                            Toast.makeText(
                                this, "You are registered successfully.",
                                Toast.LENGTH_SHORT
                            ).show()

                            val intent = Intent(this, RegisterPage::class.java).apply {
                                putExtra("user_id", firebaseUser.uid)
                                putExtra("pass_id", password)
                                flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            }
                            startActivity(intent)
                            finish()
                        } else {
                            theBase.signInWithEmailAndPassword(username, password)
                            .addOnCompleteListener { mTask ->
                                if (mTask.isSuccessful) {
                                    val intent =
                                        Intent(this, RegisterPage::class.java).apply {
                                            putExtra("user_id", "You're in")
                                            putExtra("pass_id", password)
                                        }
                                    startActivity(intent)
                                    finish()
                                } else {
                                    // If the registering is not successful then show error message.
                                    Toast.makeText(
                                        this,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
//                    })
                    }
                }
            }
        }
    }  // end of class