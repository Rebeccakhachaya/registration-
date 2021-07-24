package com.example.mobile

import com.example.mobile.models.LoginRequest
import com.example.mobile.models.LoginResponce
import com.example.mobile.models.Regirationrequest
import com.example.mobile.models.RegistrationResponce
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body Regirationrequest: Regirationrequest): Call<RegistrationResponce>
    @POST("student/login")
    fun  loginStudent(@Body LoginRequest:LoginRequest):Call<LoginResponce>
}
