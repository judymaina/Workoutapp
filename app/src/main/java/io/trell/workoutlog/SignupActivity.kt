package io.trell.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var btnSignup: Button
    lateinit var tilFirstname: TextInputLayout
    lateinit var etFirstname: TextInputEditText
    lateinit var tilLastname: TextInputLayout
    lateinit var etLastname: TextInputEditText
    lateinit var tvhaveaccount: TextView
    lateinit var tilconfirmpassword: TextInputLayout
    lateinit var etconfirmpassword: TextInputEditText
    lateinit var tilpassword: TextInputLayout
    lateinit var etpassword:TextInputEditText
    lateinit var tilemail: TextInputLayout
    lateinit var etemail: TextInputEditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignup=findViewById(R.id.btnSignup)
        tilFirstname=findViewById(R.id.tilFirstname)
        etFirstname=findViewById(R.id.etFirstname)
        tilLastname=findViewById(R.id.tilLastname)
        etLastname=findViewById(R.id.etLastname)
        tvhaveaccount=findViewById(R.id.tvhaveaccount)
        tilconfirmpassword=findViewById(R.id.tilconfirmpassword)
        etconfirmpassword=findViewById(R.id.etconfirmpassword)
        tilpassword=findViewById(R.id.tilpassword)
        etpassword=findViewById(R.id.etPassword)
        tilemail=findViewById(R.id.tilemail)
        etemail=findViewById(R.id.etemail)

        btnSignup.setOnClickListener {
            validateSignup()
        }
        tvhaveaccount.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }


    fun validateSignup(){
        var emaill=etemail.text.toString()
        var Password=etpassword.text.toString()
        var confirmpassword=etconfirmpassword.text.toString()
        var Lastname=etLastname.text.toString()
        var Firstname=etFirstname.text.toString()

        if(emaill.isBlank()){
            tilemail.error="Email is required"
        }
        if(confirmpassword.isBlank()){
            tilconfirmpassword.error="confirmedpassword is required"
        }
        if(Lastname.isBlank()){
            tilLastname.error="Lastname is required"
        }
        if(Firstname.isBlank()){
            etFirstname.error="Firstname is required"
        }

        if(Password.isBlank()){
            tilpassword.error="Password is required"
        }
    }
}