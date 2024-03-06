package com.example.simpleandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        object : CountDownTimer(3000, 100) {

            override fun onTick(millisUntilFinished: Long) {
               //tidak dipakai
            }

            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }.start()
    }
}