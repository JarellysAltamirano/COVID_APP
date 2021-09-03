package com.example.covid_appj

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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

}