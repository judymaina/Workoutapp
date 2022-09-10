package io.trell.workoutlog.api

import io.trell.workoutlog.models.LoginRequest
import io.trell.workoutlog.models.LoginResponse
import io.trell.workoutlog.models.RegisterRequest
import io.trell.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
}