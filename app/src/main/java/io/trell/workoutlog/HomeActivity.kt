package io.trell.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var fcvHome:FragmentContainerView
    lateinit var bnvHome:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castViews()
        setupBottomNav()
    }
    fun castViews(){
        fcvHome=findViewById(R.id.fcvHome)
        bnvHome =findViewById(R.id.bnvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,PlanFragment()).commit()
                    true
                }
                R.id.track->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,TrackFragment()).commit()
                    true
                }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,ProfileFragment()).commit()
                    true
                }
                else->false

            }
        }
    }
}