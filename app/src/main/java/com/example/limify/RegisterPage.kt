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


//    binding.registerBtn.setOnClickListener { it: View!
//
//        val firstName = binding.firstName.text.toString()
//        val lastName = binding.lastName.text.toString()
//        val age = binding.age.text.toString()
//        val userName = binding.userName.text.toString()
//
//        database FirebaseDatabase.getInstance().getReference( path: "Users")
//        val User = User (firstName, lastName, age, userName)
//
//        database.child(userName).setValue(User).addOnSuccessListener {
//
//            binding.firstName.text.clear()
//            binding.lastName.text.clear()
//            binding.age.text.clear()
//            binding.userName.text.clear()
//
//            Toast.makeText( context: this, text: "Successfully Saved", Toast.LENGTH_SHORT).show()
//        }).addOnFailureListener{
//            Toast JakeText(context this, text "Failed", Toast.LENGTH_SHORT).show()
//        }
//
//    }



    fun registerListener() {

        bind.RegisterButton.setOnClickListener{

            var ausername = bind.usernameTextInputLayout.editText?.text.toString().trim()
            var apassword = bind.passwordTextInputLayout.editText?.text.toString().trim()

            if(ausername.isEmpty() || apassword.isEmpty()) {
                TextUtils.isEmpty(
                    bind.usernameTextInputLayout.editText?.text.toString().trim { it <= ' ' }) .apply {
                    Toast.makeText(this@RegisterPage, "Please enter username.", Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(
                    bind.passwordTextInputLayout.editText?.text.toString().trim { it <= ' ' }).apply {
                    Toast.makeText(this@RegisterPage, "Please enter password.", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                val theBase = FirebaseAuth.getInstance()
                val username: String = ausername
                val password: String = apassword

                theBase.createUserWithEmailAndPassword(username, password)
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


//        val userId = intent.getStringExtra( "user_id")
//        val passId = intent.getStringExtra( "pass_id")
//
//        bind.usernameTextView.text = "User ID :: $userId"
//        bind.passwordTextView.text = "Password ID :: $passId"

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