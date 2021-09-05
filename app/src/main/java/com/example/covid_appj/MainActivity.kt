package com.example.covid_appj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listapaciente= emptyList<paciente>()

        val database = AppDatabase.getDatabase(this)

        database.pacientes().getAll().observe(this, Observer {
            listapaciente = it

            val adapter = pacienteAdapter(this, listapaciente)

            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, PacienteActivity::class.java)
            intent.putExtra("id", listapaciente[position].idPaciente)
            startActivity(intent)
        }

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, NuevoPacienteAtivity::class.java)
            startActivity(intent)
        }
    }
}