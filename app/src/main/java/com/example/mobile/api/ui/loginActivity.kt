package com.example.mobile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.databinding.ActivityLoginBinding
import com.example.mobile.models.LoginRequest
import com.example.mobile.viewmodel.LoginViewModel


class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val loginViewModel: LoginViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnlogin.setOnClickListener {
            var loginRequest = LoginRequest(
                binding.etlogemail.text.toString(),
                binding.etlogpassword.text.toString()
            )
            loginViewModel.loginStudent(loginRequest)
        }

    }

    override fun onResume() {
        super.onResume()

        loginViewModel.logInLiveData.observe(this, { LoginResponce ->
            Toast.makeText(baseContext, LoginResponce.message, Toast.LENGTH_LONG).show()
            var editor=sharedPreferences.edit()
            editor.putString("ACCESS_TOKEN",LoginResponce.access_token).apply()
            editor.putString("ACCESS_TOKEN",LoginResponce.access_token).apply()
            editor.apply()

            var accessToken = null
            sharedPreferences.edit().putString("ACCESS_TOKEN",LoginResponce.access_token).apply()
            var x = sharedPreferences.getString("ACCESS_TOKEN", "")

        })
        loginViewModel.logInFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }

}





//    fun clickRegister() {
//        var error = false
//        btnlogin.setOnClickListener {
//            var intent = Intent(baseContext, coursesActivity::class.java)
//            startActivity(intent)
//            var email = etlogemail.text.toString()
//            if (email.isEmpty()) {
//                error = true
//                etlogemail.setError("email  is required")
//            }
//            var phone = etlogpassword.text.toString()
//            if (phone.isEmpty()) {
//                error = true
//                etlogpassword.setError("password required")
//            }
//        }
//
//        var loginRequest = LoginRequest(
//            email = "email", password = "password"
//        )
//        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//        var request = retrofit.loginStudent(loginRequest)
//        request.enqueue(object : Callback<LoginResponce> {
//            override fun onResponse(call: Call<LoginResponce>, response: Response<LoginResponce>) {
//                if (response.isSuccessful)
//                    Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG).show()
////                var intent = Intent(baseContext, coursesActivity::class.java)
////                  startActivity(intent)
//
//                if (response.isSuccessful) {
//                    Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG)
//                        .show()
//                  var intent = Intent(baseContext, coursesActivity::class.java)
//                  startActivity(intent)
//                } else {
//                    try {
//                        var error = JSONObject(response.errorBody()!!.string())
//                        Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
//                            .show()
//                    } catch (e: Exception) {
//                        Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponce>, t: Throwable) {
//                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//
//
//            }
//
//
//        }
//        )
//    }
//}
//data class Apierror(var errors: List<String>)
//
//
//
//
