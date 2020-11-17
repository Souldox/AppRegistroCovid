package com.example.appregistrocovid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appregistrocovid.DTO.Paciente;
import com.example.appregistrocovid.helpers.PacientesListAdapter;

import java.util.Date;
import java.util.List;

public class Principal extends AppCompatActivity {

    private List<Paciente> pacientes;
    private ListView pacientesLV;

    private PacientesListAdapter adapter;


    protected void onResume(){
        super.onResume();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    }


    public void verPaciente(View view){
        Intent vista = new Intent(this,vistaPaciente.class);
        startActivity(vista);
    }

    //boton registro de paciente
    public void RegistroPaciente(View view){

        Intent Registro = new Intent(this, RegistroDePaciente.class);
        startActivity(Registro);

    }
}