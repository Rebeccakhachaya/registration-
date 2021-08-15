package com.example.mobile.api

import com.example.mobile.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
        @POST("/students/register")
        suspend fun registerStudent(@Body registrationResp: RegistrationRequest): Response<RegistrationResponce>

        @POST("courses")
        suspend fun courses(@Body courseRequest: CourseRequest): Response<CourseResponce>
        suspend fun loginStudent(@Body loginRequest: LoginRequest): Response<LoginResponce>
        @GET("/login")

}


