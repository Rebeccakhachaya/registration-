package com.example.mobile.repository

import com.example.mobile.api.ApiClient
import com.example.mobile.api.ApiInterface
import com.example.mobile.models.LoginRequest
import com.example.mobile.models.LoginResponce
import com.example.mobile.models.RegistrationRequest
import com.example.mobile.models.RegistrationResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerstudent(registrationRequest: RegistrationRequest):Response<RegistrationResponce> =
        withContext(Dispatchers.IO){
            var responce =apiInterface.registerStudent(registrationRequest)
            return@withContext responce
        }
    suspend fun loginStudent(loginRequest: LoginRequest):
            Response<LoginResponce> =
        withContext(Dispatchers.IO) {
            return@withContext ApiClient.api.loginStudent(loginRequest)
        }
}













