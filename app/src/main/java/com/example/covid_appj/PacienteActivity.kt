package com.example.covid_appj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_paciente.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class PacienteActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var paciente: paciente
    private lateinit var pacienteLiveData: LiveData<paciente>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        database = AppDatabase.getDatabase(this)


        val idPaciente = intent.getIntExtra("id", 0)

        pacienteLiveData = database.pacientes().get(idPaciente)

        pacienteLiveData.observe(this, Observer {
            paciente = it

            nombrePaciente.text = paciente.nombre
            apellidoPac.text = paciente.apellido
            edadPacien.text = "${paciente.edad}"
            sintomas_que_presenta.text = paciente.sintomas
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.paciente_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.item_editar -> {
                val intent = Intent(this, NuevoPacienteAtivity::class.java)
                intent.putExtra("paciente", paciente)
                startActivity(intent)

            }
            R.id.item_borrar -> {
                pacienteLiveData.removeObservers(this)
                CoroutineScope(Dispatchers.IO).launch {
                    database.pacientes().delete(paciente)
                    this@PacienteActivity.finish()
                }


            }

        }

        return super.onOptionsItemSelected(item)
    }
}
