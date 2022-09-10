package io.trell.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        val accessToken=sharedPreferences.getString("ACCESS_TOKEN","")
        if (accessToken!!.isNotBlank()){
            startActivity(Intent(this, HomeActivity::class.java))
        }

        else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}