package com.example.covid_appj

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.paciente_list.view.*

class pacienteAdapter(private val mContext: Context, private val listapaciente: List<paciente>) : ArrayAdapter<paciente>(mContext, 0, listapaciente){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.paciente_list, parent, false)

        val paciente = listapaciente[position]

        layout.txtnombre_paciente.text = paciente.nombre
        layout.txtapell_paciente.text = paciente.apellido
        layout.txtedad_paciente.text = "${paciente.edad}"
        layout.txtsintomas_paciente.text = paciente.sintomas
        layout.txtdireccion.text = paciente.direccion

        return layout


    }

}


