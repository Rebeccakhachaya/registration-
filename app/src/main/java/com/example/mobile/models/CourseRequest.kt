package com.example.mobile.models

import com.google.gson.annotations.SerializedName

data class CourseRequest(
    @SerializedName("course_code")var courseCode:String,
    @SerializedName("course_name")var courseName:String,
    var description:String,
    var instructor :String

)
