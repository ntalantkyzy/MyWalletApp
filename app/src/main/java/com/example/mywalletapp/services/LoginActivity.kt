package com.example.mywalletapp.services
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywalletapp.MainActivity
import com.example.mywalletapp.R
import com.example.mywalletapp.services.SharedPreference

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreference = SharedPreference(this)

        if (!sharedPreference.login.isNullOrBlank() && !sharedPreference.password.isNullOrBlank()){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}