package io.trell.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.trell.workoutlog.databinding.ActivityLoginBinding
import io.trell.workoutlog.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
        binding.tvhaveaccount.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }


    fun validateSignup(){
        var emaill=binding.etemail.text.toString()
        var Password=binding.etPassword.text.toString()
        var confirmpassword=binding.etconfirmpassword.text.toString()
        var Lastname=binding.etLastname.text.toString()
        var Firstname=binding.etFirstname.text.toString()

        if(emaill.isBlank()){
            binding.tilemail.error="Email is required"
        }
        if(confirmpassword.isBlank()){
            binding.tilconfirmpassword.error="confirmedpassword is required"
        }
        if(Lastname.isBlank()){
           binding.tilLastname.error="Lastname is required"
        }
        if(Firstname.isBlank()){
            binding.etFirstname.error="Firstname is required"
        }

        if(Password.isBlank()){
           binding.tilpassword.error="Password is required"
        }
    }
}