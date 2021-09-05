package com.example.covid_appj

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PacientesDao {
    @Query("SELECT * FROM pacientes")
    fun getAll(): LiveData<List<paciente>>

    @Query("SELECT * FROM pacientes WHERE idPaciente = :id")
    fun get(id: Int): LiveData<paciente>

    @Insert
    fun insertAll(vararg paciente: paciente)

    @Update
    fun update(paciente: paciente)

    @Delete
    fun delete(paciente: paciente)

}