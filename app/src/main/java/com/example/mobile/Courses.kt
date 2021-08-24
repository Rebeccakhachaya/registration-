package com.example.mobile

import com.google.gson.annotations.SerializedName

data class Courses(
    @SerializedName("course_code")var courseCode:String,
    @SerializedName("course_name")var courseName:String,
    var description:String,
    var instructor :String)
