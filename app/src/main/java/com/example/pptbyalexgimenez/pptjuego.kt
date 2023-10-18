package com.example.pptbyalexgimenez

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class pptjuego : AppCompatActivity() {

    /*----------INICIALIZACION DE VARIABLES A NIVEL DE CLASE----------*/

    //INICIALIZACION PARCIAL BOTONES
    lateinit var paper: ImageButton
    lateinit var scissors: ImageButton
    lateinit var rock: ImageButton

    //INICIALIZACION PARCIAL OPCIONES DE LA MAQUINA
    lateinit var optionPaperIA: ImageView
    lateinit var optionRockIA: ImageView
    lateinit var optionTijeraIA: ImageView

    //INICIALIZACION VALOR RANDOM
    val random = Random

    //INICIALZACION CONTADORES
    var contadorVictorias: Int = 0
    var contadorVictoriasIA: Int = 0

    lateinit var victoriasIA : TextView
    lateinit var victorias : TextView

                /*----------INICIA LA ACTIVITY----------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pptjuego)
        abandonarJuego()
    }

    @SuppressLint("MissingSuperCall")//Linea usada para evitar error que detecta falta de un super
    //dentro de la funcion override
    override fun onBackPressed() { //funcion que desahibilita el boton "BACK" de Android
        onBackPressedDispatcher
    }

                /*----------FUNCIONES----------*/

        /*----------EN CASO DE QUE USER COGE PAPEL----------*/

    fun papel(view: View) {
        //PREPARAMOS IDs PARA DESPUES PODER MOSTRARLO
        paper = findViewById(R.id.paperbutton)
        optionPaperIA = findViewById(R.id.optionIApapel)
        optionRockIA = findViewById(R.id.optionIApiedra)
        optionTijeraIA=findViewById(R.id.optionIAtijera)

        //CONTADOR INICIALIZADORES PARA MOSTRAR
        victorias = findViewById(R.id.contadorVictorias)
        victoriasIA = findViewById(R.id.contadorVictoriasIA)

        //CONVERSION DEL TAG DEL PAPEL A INT
        val numPapel = paper.tag?.toString()?.toIntOrNull() ?: 0

        //SELECCION NUMERO ALEATORIO
        val numAleatorio = random.nextInt(1, 4)

        //INICIO DEL JUEGO
        if (numAleatorio == numPapel) { //Si la IA escoge papel
            optionPaperIA.visibility = View.VISIBLE     //Hago visible la opcion de papel
            optionTijeraIA.visibility=View.INVISIBLE    //Invisible Tijera
            optionRockIA.visibility=View.INVISIBLE  //Invisible Rock
            val toast1 = Toast.makeText(this, "¡HAS EMPATADO!", Toast.LENGTH_SHORT) //Muestra
            // en esta screen (this), el texto, con una duracion corta
            toast1.setGravity(Gravity.CENTER, 0, 0);    //Ubico el toast en el centro
            toast1.show()   //muestro el toast

        } else if (numAleatorio == 2) { //Si la IA escoge el numero 2 (Roca)
            optionRockIA.visibility=View.VISIBLE    //Hago visible la opcion de Roca
            optionPaperIA.visibility = View.INVISIBLE   //Inivisible papel
            optionTijeraIA.visibility=View.INVISIBLE    //Invisible tijera
            val toast2 = Toast.makeText(this, "¡HAS GANADO!", Toast.LENGTH_SHORT)   //Muestra
            //en esta screen (this), el texto, con una duracion corta
            toast2.setGravity(Gravity.CENTER, 0, 0); //Ubico el toast en el centro
            toast2.show()  //muestro el toast
            contadorVictorias++ //Incremento en 1 el contador de Victorias
            victorias.text = contadorVictorias.toString()   //Convierto a String el contador
        } else {    //Si escoje el numero 3 (Tijeras)
            
            optionTijeraIA.visibility=View.VISIBLE  //Muestro tijeras
            optionRockIA.visibility=View.INVISIBLE  //Oculto Piedra
            optionPaperIA.visibility = View.INVISIBLE   //Oculto papel
            val toast3 = Toast.makeText(this, "¡HAS PERDIDO!", Toast.LENGTH_SHORT)  //Muestra
            //en esta screen (this), el texto, con una duracion corta
            toast3.setGravity(Gravity.CENTER, 0, 0); //Ubico el toast en el centro
            toast3.show()   //muestro el toast
            contadorVictoriasIA++   //Incremento las Victorias de la IA
            victoriasIA.text = contadorVictoriasIA.toString()   //Convierto a String el contador
        }
    }

        /*----------EN CASO DE QUE USER COGE ROCA----------*/

    fun rock(view: View){
        //PREPARAMOS IDs PARA DESPUES PODER MOSTRARLO
        rock = findViewById(R.id.rockbutton)
        optionPaperIA = findViewById(R.id.optionIApapel)
        optionRockIA = findViewById(R.id.optionIApiedra)
        optionTijeraIA=findViewById(R.id.optionIAtijera)

        //CONTADORES
        victorias = findViewById(R.id.contadorVictorias)
        victoriasIA = findViewById(R.id.contadorVictoriasIA)

        //CONVERSION DEL TAG DEL PAPEL A INT
        val numRock = rock.tag?.toString()?.toIntOrNull() ?: 0

        //SELECCION NUMERO ALEATORIO
        val numAleatorio = random.nextInt(1, 4)

        //INICIO DEL JUEGO
        if (numAleatorio == numRock) {
            optionPaperIA.visibility = View.INVISIBLE
            optionTijeraIA.visibility=View.INVISIBLE
            optionRockIA.visibility=View.VISIBLE
            val toast1 = Toast.makeText(this, "¡HAS EMPATADO!", Toast.LENGTH_SHORT)
            toast1.setGravity(Gravity.CENTER, 0, 0)
            toast1.show()

        } else if (numAleatorio == 3) {
            optionRockIA.visibility=View.INVISIBLE
            optionPaperIA.visibility = View.INVISIBLE
            optionTijeraIA.visibility=View.VISIBLE
            val toast2 = Toast.makeText(this, "¡HAS GANADO!", Toast.LENGTH_SHORT)
            toast2.setGravity(Gravity.CENTER, 0, 0)
            toast2.show()
            contadorVictorias++
            victorias.text = contadorVictorias.toString()
        } else {
            optionTijeraIA.visibility=View.INVISIBLE
            optionRockIA.visibility=View.INVISIBLE
            optionPaperIA.visibility = View.VISIBLE
            val toast3 = Toast.makeText(this, "¡HAS PERDIDO!", Toast.LENGTH_SHORT)
            toast3.setGravity(Gravity.CENTER, 0, 0)
            toast3.show()


            contadorVictoriasIA++
            victoriasIA.text = contadorVictoriasIA.toString()
        }
    }

        /*----------EN CASO DE QUE USER COGE TIJERAS----------*/

    fun tijeras(view: View){
        //PREPARAMOS IDs PARA DESPUES PODER MOSTRARLO
        scissors = findViewById(R.id.scissorsbutton)
        optionPaperIA = findViewById(R.id.optionIApapel)
        optionRockIA = findViewById(R.id.optionIApiedra)
        optionTijeraIA=findViewById(R.id.optionIAtijera)

        //CONTADORES
        victorias = findViewById(R.id.contadorVictorias)
        victoriasIA = findViewById(R.id.contadorVictoriasIA)

        //CONVERSION DEL TAG DEL PAPEL A INT
        val numTijera = scissors.tag?.toString()?.toIntOrNull() ?: 0

        //SELECCION NUMERO ALEATORIO
        val numAleatorio = random.nextInt(1, 4)

        //INICIO DEL JUEGO
        if (numAleatorio == numTijera) {
            optionPaperIA.visibility = View.INVISIBLE
            optionTijeraIA.visibility=View.VISIBLE
            optionRockIA.visibility=View.INVISIBLE
            val toast1 = Toast.makeText(this, "¡HAS EMPATADO!", Toast.LENGTH_SHORT)
            toast1.setGravity(Gravity.CENTER, 0, 0)
            toast1.show()

        } else if (numAleatorio == 1) {
            optionRockIA.visibility=View.INVISIBLE
            optionPaperIA.visibility = View.VISIBLE
            optionTijeraIA.visibility=View.INVISIBLE
            val toast2 = Toast.makeText(this, "¡HAS GANADO!", Toast.LENGTH_SHORT)
            toast2.setGravity(Gravity.CENTER, 0, 0)
            toast2.show()
            contadorVictorias++
            victorias.text = contadorVictorias.toString()
        } else {
            optionTijeraIA.visibility=View.INVISIBLE
            optionRockIA.visibility=View.VISIBLE
            optionPaperIA.visibility = View.INVISIBLE
            val toast3 = Toast.makeText(this, "¡HAS PERDIDO!", Toast.LENGTH_SHORT)
            toast3.setGravity(Gravity.CENTER, 0, 0)
            toast3.show()


            contadorVictoriasIA++
            victoriasIA.text = contadorVictoriasIA.toString()
        }
    }

    /*----------EN CASO DE QUE USER QUIERA ABANDONAR LA PARTIDA----------*/

    fun abandonarJuego(){       //Funcion para boton abandonar Juego
        val abandono : Button = findViewById(R.id.botonAbandonar)   //Creo la variable que guarda el boton
        abandono.setOnClickListener {   //Escucho la pulsación de dicho boton
            val intent: Intent = Intent(this, MainActivity:: class.java)    //Creo un intent
            //que actua sobre esta actividad (this) y nos envia a la clase MainActivity
            startActivity(intent)   //Inicio el intent
        }
    }
}