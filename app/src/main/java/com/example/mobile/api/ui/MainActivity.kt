package com.example.mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.databinding.ActivityMainBinding
import com.example.mobile.models.RegistrationRequest
import com.example.mobile.models.RegistrationResponce
import com.example.mobile.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
     val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.btnBUTTON.setOnClickListener {
        }
        fun registerStudent() {
            var name = binding.etName.toString()
            var phoneNumber = binding.etPhone.text.toString()
            var email = binding.etEmail.toString()
            var dob = binding.etDob.text.toString()
            var password = binding.etPassword.text.toString()
            var registrationRequest = RegistrationRequest(
                name = name,
                phoneNumber = phoneNumber,
                email = email,
                dob = dob,
                password = password,


        }
        userViewModel.registrationLiveData.observe(this, { regResponse->
                    if (!regResponse.password.isNullOrEmpty()){
                        Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
                    }
                })
                        userViewModel.registrationLiveData.observe(this, { error->
                            Toast.makeText(baseContext, "Registration failed ", Toast.LENGTH_LONG).show()


                        })
        }




}





































