package com.example.limify

import Database.GlobalVar
import Model.DAOUser
import com.example.limify01.model.User
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.limify.databinding.ActivityResultBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class ResultActivity : AppCompatActivity() {

    private lateinit var viewBind: ActivityResultBinding
    private var position = -1
    private lateinit var theUID:String
    private lateinit var DAO: DAOUser

    private val GetResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){   // APLIKASI GALLERY SUKSES MENDAPATKAN IMAGE
            val uri = it.data?.data                 // GET PATH TO IMAGE FROM GALLEY
            viewBind.pictureImageview.setImageURI(uri)  // MENAMPILKAN DI IMAGE VIEW
            GlobalVar.listDataUser[position].imageUri = uri.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityResultBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        theUID = FirebaseAuth.getInstance().currentUser!!.uid
        GetIntent()
        Listener()
    }

    private fun Listener(){
        viewBind.pictureImageview.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            myIntent.type = "image/*"
            GetResult.launch(myIntent)
        }

        viewBind.pictureFab.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            myIntent.type = "image/*"
            GetResult.launch(myIntent)
        }

        viewBind.DeleteButton.setOnClickListener{

            DAOUser().delete(theUID).addOnSuccessListener {
                Toast.makeText(this, "User Successfully Deleted" ,Toast.LENGTH_LONG)
                startActivity(Intent(this, LoginPage::class.java))
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to delete User" ,Toast.LENGTH_LONG)
            }


        }

        viewBind.EditButton.setOnClickListener{
            val myIntent = Intent(this, FormActivity::class.java).apply {
                putExtra("position", position)
            }

            startActivity(myIntent)
        }
    }

    private fun GetIntent(){
        position = intent.getIntExtra("position", -1)
        val user = GlobalVar.listDataUser[position]
        Display(user)
    }

    override fun onResume() {
        super.onResume()
        val user = GlobalVar.listDataUser[position]
        Display(user)
    }

    private fun Display(user:User){
        viewBind.NamaTextView.text = user.nama
        viewBind.AlamatTextView.text = user.alamat
        viewBind.NoTelpTextView.text = user.no_telp
        viewBind.EmailTextView.text = user.email
        viewBind.PasswordTextView.text = user.password
        if (user.imageUri.isNotEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                baseContext.getContentResolver().takePersistableUriPermission(Uri.parse(user.imageUri),
                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )
            }
            viewBind.pictureImageview.setImageURI(Uri.parse(user.imageUri))
        }
    }

}