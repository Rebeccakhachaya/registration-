package com.example.mobile.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.models.Regirationrequest
import com.example.mobile.models.RegistrationResponce
import com.example.mobile.repository.UserRepository


class UserViewModel: ViewModel() {
    var registrationLiveData = MutableLiveData<RegistrationResponce>()
    var regError = MutableLiveData<String>()
    val userRepository = UserRepository()

    fun registerStudent(registrationRequest: RegistrationResponce) {
        viewModelScope.launch {
            val response = userRepository.registerStudent(Regirationrequest)
            if (response.isSuccessful) {
                registrationLiveData.postValue(response.body())
            } else {
                regError.postValue(response.errorBody()?.string())
            }
        }
    }
}

