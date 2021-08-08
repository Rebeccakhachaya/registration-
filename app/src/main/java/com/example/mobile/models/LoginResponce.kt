package com.example.mobile.models

import com.google.gson.annotations.SerializedName

data class LoginResponce(
    var message:String,
    @SerializedName("access_token")
    var access_token:String,
    @SerializedName("student_id")
    var student_id:String,


)
