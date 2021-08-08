package com.example.mobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.models.CourseResponce
import com.example.mobile.repository.UserRepository

class CoursesViewModel:ViewModel() {
    var coursesLiveData = MutableLiveData<CourseResponce>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun Courses(courseResponce: CourseResponce, viewModelScope: Any){
        viewModelScope.launch {
            var response = userRepository.login(courseResponce)
            if (response.isSuccessful){
                coursesLiveData.postValue(courseResponce.body())
            }
            else{
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
