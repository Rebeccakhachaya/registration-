package com.example.mobile.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.models.RegistrationRequest
import com.example.mobile.models.RegistrationResponce
import com.example.mobile.repository.UserRepository



class UserViewModel:ViewModel(){
    var registrationLiveData = MutableLiveData<RegistrationResponce>()
    var regErrorLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun registerUser(registrationRequest: RegistrationRequest) {


//            var responce = userRepository.registerstudent(registrationRequest)
//
//            if (responce.isSuccessful) {
//                registrationLiveData.postValue(responce.body())
//            } else {
//                regErrorLiveData.postValue(responce.body()?.toString())
//
//            }


        }


    }


}