package com.example.gymius

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vishnusivadas.advanced_httpurlconnection.PutData


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in)

        val usernameEditText : EditText = findViewById(R.id.username)
        val passwordEditText : EditText = findViewById(R.id.password)
        val loginButton : Button = findViewById(R.id.login_button)
        val loginProgressBar : ProgressBar = findViewById(R.id.login_loading)

        // OnClick function for Login Screen
        loginButton.setOnClickListener{

            loginProgressBar.visibility = ProgressBar.VISIBLE
            var username : String = usernameEditText.text.toString()
            var password : String = passwordEditText.text.toString()

            if(!username.equals("") && !password.equals("")) {

                val handler = Handler(Looper.getMainLooper())
                handler.post(Runnable {
                    val field = arrayOfNulls<String>(2)
                    field[0] = "username"
                    field[1] = "password"
                    //Creating array for data
                    val data = arrayOfNulls<String>(2)
                    data[0] = "data-1"
                    data[1] = "data-2"
                    val putData = PutData(
                        "http://localhost/Gymius_Login-Signup/login.php",
                        "POST",
                        field,
                        data
                    )
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            val result = putData.result
                            loginProgressBar.visibility = ProgressBar.INVISIBLE
                            if(result.equals("Login Success")){
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    //End Write and Read data with URL
                })
            } else {
                Toast.makeText(applicationContext, "All fields are required", Toast.LENGTH_SHORT).show()
            }
        }
    }
}