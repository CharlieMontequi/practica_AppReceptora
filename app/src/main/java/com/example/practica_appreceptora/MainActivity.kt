package com.example.practica_appreceptora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mensajeRecivido : TextView = findViewById(R.id.txtV_mostrarMensaje)
    }
}