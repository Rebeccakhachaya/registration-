package com.example.mobile

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.api.ApiClient
import com.example.mobile.models.Regirationrequest
import com.example.mobile.models.RegistrationResponce
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var spnationality: Spinner
    lateinit var btnButton: Button
    lateinit var etName: EditText
    lateinit var etDob: EditText
    lateinit var etEmail: EditText
    lateinit var etpassword: EditText
    private lateinit var etphone: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()

    }

       fun castViews() {
            etName = findViewById(R.id.etName)
            etDob = findViewById(R.id.etDob)
            spnationality = findViewById(R.id.spnationality)
            etEmail = findViewById(R.id.etEmail)
            etphone = findViewById(R.id.etPhone)
            btnButton = findViewById(R.id.btnBUTTON)
            etpassword = findViewById(R.id.etPassword)

            var nationality = arrayOf("Kenyan", "Ugandan", "Rwandan", "South sudan")
            var nationalityAdapter =
                ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
            nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnationality.adapter = nationalityAdapter
           btnButton.setOnClickListener {
               var intent=Intent(baseContext,loginActivity::class.java)
               startActivity(intent)
           }
          clickRegister()
        }
    fun clickRegister() {
        var error = false
        btnButton.setOnClickListener {
            var name = etName.text.toString()
            if (name.isEmpty()) {
                error = true
                etName.setError("Name is required")
            }
            var dob = etDob.text.toString()
            if(dob.isEmpty()){
                error=true
                etDob.setError("Date of birth required")
            }
            var nationality = spnationality.selectedItem.toString()
            var password = etpassword.text.toString()
            if (password.isEmpty()){
                error=true
                etpassword.setError("password required")
            }
            var phone = etphone.text.toString()
            if(phone.isEmpty()){
                error=true
                etphone.setError("phoneNumber required")
            }
            var email = etEmail.text.toString()
            if(email.isEmpty()) {
                error = true
                etEmail.setError("Email required")
            }
            var regestrationRequest=Regirationrequest(
                name=name,phoneNumber=phone,email=email,nationality=nationality.toUpperCase(),dob=dob,password=password
            )
            var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
            var request=retrofit.registerStudent(regestrationRequest)
            request.enqueue(object :Callback<RegistrationResponce> {
                override fun onResponse(
                    call: Call<RegistrationResponce>,
                    response: Response<RegistrationResponce>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG)
                            .show()
                        var intent = Intent(baseContext, loginActivity::class.java)
                        startActivity(intent)
                    }


                    else{
                        try {
                            var error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                .show()
                        } catch (e: Exception) {
                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }



                override fun onFailure(call: Call<RegistrationResponce>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}

data class ApiError(var errors: List<String>)












