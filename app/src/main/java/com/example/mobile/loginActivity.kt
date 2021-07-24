package com.example.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mobile.api.ApiClient
import com.example.mobile.models.LoginRequest
import com.example.mobile.models.LoginResponce
import com.example.mobile.models.RegistrationResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity : AppCompatActivity() {
    lateinit var etlogemail: EditText
    lateinit var etlogpassword: EditText
    lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    fun castView() {
        etlogemail = findViewById(R.id.etlogemail)
        etlogpassword = findViewById(R.id.etlogpassword)
        btnlogin = findViewById(R.id.btnlogin)
    }

    fun clickRegister() {
        var error = false
        btnlogin.setOnClickListener {
            var email = etlogemail.text.toString()
            if (email.isEmpty()) {
                error = true
                etlogemail.setError("email  is required")
            }
            var phone = etlogpassword.text.toString()
            if (phone.isEmpty()) {
                error = true
                etlogpassword.setError("password required")
            }
        }

        var loginRequest = LoginRequest(
            email = "email", password = "password"
        )
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.loginStudent(loginRequest)
        request.enqueue(object : Callback<LoginResponce> {
            override fun onResponse(call: Call<LoginResponce>, response: Response<LoginResponce>) {
                if(response.isSuccessful)
                    Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG).show()





            }

            override fun onFailure(call: Call<LoginResponce>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }

        })

    }
}




