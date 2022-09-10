package io.trell.workoutlog.repository

import io.trell.workoutlog.api.ApiClient
import io.trell.workoutlog.api.ApiInterface
import io.trell.workoutlog.models.LoginRequest
import io.trell.workoutlog.models.RegisterRequest
import io.trell.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest) = withContext(Dispatchers.IO) {
        val response = apiClient.login(loginRequest)
        return@withContext response


    }
    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>
            = withContext(Dispatchers.IO) {
        val response = apiClient.registerUser(registerRequest)
        return@withContext response
}

    }

