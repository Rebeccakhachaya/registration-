package com.example.mobile.repository

import com.example.mobile.api.ApiClient
import com.example.mobile.models.CourseResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {



    class CoursesRepository() {
//    private val  apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

        suspend fun getCourses(access_token:String):
                Response<List<CourseResponce>> =
            withContext(Dispatchers.IO){
                return@withContext ApiClient.api.getCourses(access_token)
            }
    }
}
