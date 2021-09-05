package com.example.covid_appj

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "pacientes")

class paciente(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val direccion: String,
    val sintomas: String,

    @PrimaryKey(autoGenerate = true)
    var idPaciente: Int = 0
) : Serializable
