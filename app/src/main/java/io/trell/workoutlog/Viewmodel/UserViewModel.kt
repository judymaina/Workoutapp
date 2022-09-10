package io.trell.workoutlog.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.trell.workoutlog.models.LoginRequest
import io.trell.workoutlog.models.LoginResponse
import io.trell.workoutlog.models.RegisterRequest
import io.trell.workoutlog.models.RegisterResponse
import io.trell.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel (){
    val userRepository=UserRepository()
    var loginResponseLiveData =MutableLiveData<LoginResponse>()
    val loginErrorLiveData =MutableLiveData<String?>()

    val registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val registerErrorLiveData =MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response =userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                val error=response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response =userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
               registerResponseLiveData.postValue(response.body())
            }
}
    }



       }
