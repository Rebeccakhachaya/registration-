package com.example.mobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.models.LoginRequest
import com.example.mobile.models.LoginResponce
import com.example.mobile.repository.UserRepository

class LoginViewModel:ViewModel () {
    var logInLiveData = MutableLiveData<LoginResponce>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun loginStudent(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginStudent(loginRequest)
            if (response.isSuccessful) {
                logInLiveData.postValue(response.body())
            } else {
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}



