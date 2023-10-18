package com.example.pptbyalexgimenez

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) //con esta linea obligo
        // a la app ha quedarse en vertical
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicio()
        cerrar()
    }

    @SuppressLint("MissingSuperCall") //Linea usada para evitar error que detecta falta de un super
    //dentro de la funcion override
    override fun onBackPressed() {  //funcion que desahibilita el boton "BACK" de Android
        onBackPressedDispatcher
    }

    fun inicio() {
        val botonempezar: Button = findViewById(R.id.startgame)

        botonempezar.setOnClickListener {   //Escucho los click realizados sobre el boton Empezar
            val intent: Intent = Intent(this, pptjuego:: class.java)    //Creo objeto intent, que sirve para iniciar una nueva
                                        // Activity, this es donde se ejecuta la funcion, pptjuego... se usa para obtener la clase referenciada
            startActivity(intent)   //Inicio el intent
        }
    }


    fun cerrar(){
        val botonquit: Button = findViewById(R.id.closeapp)
        botonquit.setOnClickListener{       //Escuchador del botón
            val intentCerrar : Intent = Intent(Intent.ACTION_MAIN)  //Declaro el intent como accion principal para realizar X acción
            intentCerrar.addCategory(Intent.CATEGORY_HOME)  //Se usa esta categoria para llevar al user a la pantalla de inicio
            intentCerrar.addCategory(Intent.CATEGORY_DEFAULT)   //Agrego esta categoría que garantiza el uso de la pantalla
            startActivity(intentCerrar) //Inicio el Intent que cierra la app por completo

        }
    }
}