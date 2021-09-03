package com.example.covid_appj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paciente = paciente("Eliseo", "Davila", 21,"fiebre alta,dolor de cabeza, tos")
        val paciente2 = paciente ("Jarellys", "Altamirano", 50, "Cansancio, dolor de huesos, falta de olfato")
        val listapaciente = listOf(paciente, paciente2)
        val adapter = pacienteAdapter(this, listapaciente)
        lista.adapter = adapter
       lista.setOnItemClickListener { parent, view, position, id ->
           val intent = Intent(this, PacienteActivity::class.java)
           intent.putExtra("paciente",listapaciente[position])
           startActivity(intent)
       }

    }


    }
