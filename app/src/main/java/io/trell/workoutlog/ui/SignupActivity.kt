package io.trell.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import io.trell.workoutlog.Viewmodel.UserViewModel
import io.trell.workoutlog.databinding.ActivitySignupBinding
import io.trell.workoutlog.models.RegisterRequest
import io.trell.workoutlog.models.RegisterResponse
import io.trell.workoutlog.api.ApiClient
import io.trell.workoutlog.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    val userViewModel:UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
        binding.tvhaveaccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


    fun validateSignup(){
        var emaill=binding.etemail.text.toString()
        var Password=binding.etPassword.text.toString()
        var confirmpassword=binding.etconfirmpassword.text.toString()
        var Lastname=binding.etLastname.text.toString()
        var Firstname=binding.etFirstname.text.toString()
        var Phonenumber=binding.etPhonenumber.text.toString()

        var error=false

        if(emaill.isBlank()){
            error=true
            binding.tilemail.error="Email is required"
        }
        if(Phonenumber.isBlank()){
            error=true
            binding.tilPhonenumber.error="Phonenumber is required"
        }

        if(confirmpassword.isBlank()){
            error=true
            binding.tilconfirmpassword.error="confirmedpassword is required"
        }
        if(Lastname.isBlank()){
            error=true
           binding.tilLastname.error="Lastname is required"
        }
        if(Firstname.isBlank()){
            error=true
            binding.etFirstname.error="Firstname is required"
        }

        if(Password.isBlank()){
            error=true
           binding.tilpassword.error="Password is required"
        }
        if(!error){
            val registerRequest=RegisterRequest(Firstname,Lastname,emaill,Phonenumber,Password)
//           makeRegistrationRequest(registerRequest)
            userViewModel.registerUser(registerRequest)
        }

             }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer {
            signupResponse->
            Toast.makeText(baseContext,signupResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LoginActivity::class.java))

        })
        userViewModel.registerErrorLiveData.observe(this, Observer {
            signUpError->
            Toast.makeText(baseContext,signUpError,Toast.LENGTH_LONG).show()


        })
    }

}
