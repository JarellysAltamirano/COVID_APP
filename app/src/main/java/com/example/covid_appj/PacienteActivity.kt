package com.example.covid_appj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_paciente.*

class PacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)
        val paciente = intent.getSerializableExtra("paciente") as paciente
        nombrePaciente.text = paciente.nombre
        apellidoPac.text = paciente.apellido
        edadPacien.text = "${paciente.edad}"
        sintomas_que_presenta.text = paciente.sintomas
    }
}