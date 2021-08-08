package com.example.mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.databinding.ActivityMainBinding
import com.example.mobile.models.Regirationrequest
import com.example.mobile.models.RegistrationResponce
import com.example.mobile.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

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
            var regRequest = RegistrationResponce(
                name = binding.etName.toString(),
                phoneNumber = binding.etPhone.text.toString(),
                email = binding.etEmail.toString(),
                dob = binding.etDob.text.toString(),
                password = binding.etPassword.text.toString(),

            )
            userViewModel.registerStudent(regRequest)
        }
        userViewModel.registrationLiveData.observe(this, { regResponse->
            if (!regResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.registrationLiveData.observe(this, { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }

}


































