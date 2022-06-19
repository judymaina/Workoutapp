package io.trell.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.trell.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
   lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnlogin.setOnClickListener {
            validateLogin()
        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            val intent =Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }


    }
    fun validateLogin(){
        var email=binding.etEmail.text.toString()
        var Password=binding.etPassword.text.toString()
        var error =false
        if(email.isBlank()){
            binding.tillEmail.error="Email is required"
        }
        if(Password.isBlank()){
            binding.tilPassword.error="Password is required"
        }
        if (!error){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }
}