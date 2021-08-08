package com.example.mobile

import com.example.mobile.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    abstract fun logInStudent(loginRequest: LoginRequest): Any

    interface ApiInterface {
        @POST("/students/register")
        suspend fun registerStudent(
            @Body registrationResp:
            Regirationrequest
        ): Response<RegistrationResponce>
        interface ApiInterface {
            @POST("/students/register")
            suspend fun registerStudent(@Body registrationRequest:
                                        RegistrationResponce): Response<RegistrationResponce>
            @POST("courses")
            suspend fun courses(@Body courseRequest: CourseRequest):Response<CourseResponce>
        }




    }
}