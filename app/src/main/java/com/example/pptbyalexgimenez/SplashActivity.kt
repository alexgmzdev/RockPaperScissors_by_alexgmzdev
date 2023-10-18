package com.example.pptbyalexgimenez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        //la linea anterior inicia la actividad con un Intent, seleccionando desde esta vista(this)
        //y enviandonos a la MainActivity
    }
}