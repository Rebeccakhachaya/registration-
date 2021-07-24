package com.example.mobile.models

import com.google.gson.annotations.SerializedName

data class RegistrationResponce(
    var name:String,
    var email:String,
    var dob:String,
    var nationality:String,
    var password:String,
    @SerializedName("phone_number")var phoneNumber:String,
//    @SerializedName("student_id") var studentId:String

)
