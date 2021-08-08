package com.example.mobile.repository

import com.example.mobile.ApiInterface
import com.example.mobile.api.ApiClient
import com.example.mobile.models.LoginRequest
import com.example.mobile.models.LoginResponce
import com.example.mobile.models.Regirationrequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerStudent(Regirationrequest: Regirationrequest):
            Response<Regirationrequest> = withContext(Dispatchers.IO) {
        var response = apiInterface.(Regirationrequest)
        return@withContext response
    }
        suspend fun login(loginRequest: LoginRequest): Response<LoginRequest> =
            withContext(Dispatchers.IO) {
                var response = apiInterface.logInStudent(loginRequest)
                return@withContext response
            }


    }













