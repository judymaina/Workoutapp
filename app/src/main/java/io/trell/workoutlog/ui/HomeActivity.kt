package io.trell.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.trell.workoutlog.R
import io.trell.workoutlog.databinding.ActivityHomeBinding
import io.trell.workoutlog.models.LoginResponse
import java.util.prefs.Preferences

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
//    lateinit var fcvHome:FragmentContainerView
//    lateinit var bnvHome:BottomNavigationView
    lateinit var sharedPrefs:SharedPreferences
    lateinit var tvLogout: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        castViews()
        setupBottomNav()
        binding.tvlogout.setOnClickListener {
            val editor =sharedPrefs.edit()
            editor.putString("ACCESS_TOKEN"," ")
            editor.putString("USER_ID"," ")
            editor.putString("PROFILE_ID"," ")
            editor.apply()
            startActivity(Intent(this, LoginResponse::class.java))
        }

    }
    fun castViews(){
        binding.fcvHome
       binding. bnvHome
    }
    fun setupBottomNav(){
        binding.bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        ProfileFragment()
                    ).commit()
                    true
                }
                else->false

            }
        }
    }
}