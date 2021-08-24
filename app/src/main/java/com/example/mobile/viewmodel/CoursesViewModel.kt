package com.example.mobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.models.CourseResponce
import com.example.mobile.repository.CoursesRepository

class CoursesViewModel:ViewModel() {
    class CoursesViewModel : ViewModel() {
        var coursesLiveData = MutableLiveData<List<CourseResponce>>()
        var coursesFailedLiveData = MutableLiveData<String>()
        var coursesRepository = CoursesRepository()
        fun getCourses(access_token:String) {
            viewModelScope.launch {
                val response = coursesRepository.getCourse(access_token)
                if (response.isSuccessful) {
                    coursesLiveData.postValue(response.body())
                } else {
                    coursesFailedLiveData.postValue(response.errorBody()?.string())
                }
            }
        }


    }
}
