package io.trell.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import io.trell.workoutlog.Viewmodel.UserViewModel
import io.trell.workoutlog.databinding.ActivityLoginBinding
import io.trell.workoutlog.models.LoginRequest
import io.trell.workoutlog.models.LoginResponse
import io.trell.workoutlog.api.ApiClient
import io.trell.workoutlog.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
   lateinit var binding:ActivityLoginBinding
   lateinit var sharedPrefs:SharedPreferences
   val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

       binding.btnlogin.setOnClickListener {
            validateLogin()
        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            val intent =Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onResume(){
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer{ loginResponse->
            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        })
       userViewModel.loginResponseLiveData.observe(this, Observer { error->
           Toast.makeText(baseContext,error.message,Toast.LENGTH_LONG).show()

})
    }
    fun validateLogin(){
        var email=binding.etEmail.text.toString()
        var Password=binding.etPassword.text.toString()
        var error =false
        if(email.isBlank()){
            binding.tillEmail.error="Email is required"
            error=true
        }
        if(Password.isBlank()){
            binding.tilPassword.error="Password is required"
            error=true
        }
        if (!error){
           var loginRequest=LoginRequest(email,Password)

            binding.PbLogin
            userViewModel.loginUser(loginRequest)

        }
    }


    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor =sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()


    }

}

