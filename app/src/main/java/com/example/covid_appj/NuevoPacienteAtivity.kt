package com.example.covid_appj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevo_paciente_ativity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoPacienteAtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_paciente_ativity)
        var idpaciente: Int? = null

        if (intent.hasExtra("paciente")){
            val paciente = intent.extras?.getSerializable("paciente") as paciente
            edtNombre.setText(paciente.nombre)
            edtApellido.setText(paciente.apellido)
            edtEdad.setText(paciente.edad.toInt())
            edtSintomas.setText(paciente.sintomas)

        }

        val database = AppDatabase.getDatabase(this)

        btnGuardar.setOnClickListener {
            val nombre = edtNombre.text.toString()

            val apellido = edtApellido.text.toString()

            val edad = edtEdad.text.toString().toInt()

            val sintomas = edtSintomas.text.toString()

            val paciente = paciente(nombre, apellido, edad, sintomas)

            if (idpaciente != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    paciente.idPaciente = idpaciente
                    database.pacientes().update(paciente)
                    this@NuevoPacienteAtivity.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    database.pacientes().insertAll(paciente)
                    this@NuevoPacienteAtivity.finish()
                }

            }
        }
    }
}