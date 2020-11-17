package com.example.appregistrocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.appregistrocovid.DAO.PacientesDAO;
import com.example.appregistrocovid.DAO.PacientesDAODB;
import com.example.appregistrocovid.DTO.Paciente;

import java.util.Calendar;

public class RegistroDePaciente extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//TODO pasar los boolean a int para el sql de mierda

    private PacientesDAO pacientesDAO = new PacientesDAODB(this);

    Spinner areaSp;
    Switch aSwitch, bSwitch;
    Boolean sintomas, tos;
    String area,fecha,estadoImg;


    TextView nombreTxt,apellidoTxt,rutTxt,presionTxt,fechaTxt;
    Button registrarBtn;

    DatePickerDialog.OnDateSetListener nDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_paciente);




        this.nombreTxt = findViewById(R.id.nombrePaciente);
        this.apellidoTxt = findViewById(R.id.apellidoPaciente);
        this.rutTxt = findViewById(R.id.rutPaciente);
        this.presionTxt = findViewById(R.id.presionPaciente);
        this.registrarBtn = findViewById(R.id.btnRegistro);
        this.aSwitch = findViewById(R.id.sintomas);
        this.bSwitch = findViewById(R.id.tos);
        this.fechaTxt = findViewById(R.id.fechaSeleccionada);
        this.areaSp = findViewById(R.id.areaTrabajo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSp.setAdapter(adapter);
        areaSp.setOnItemSelectedListener(this);

        this.registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paciente p = new Paciente();
                p.setNombre(nombreTxt.getText().toString());
                p.setApellido(apellidoTxt.getText().toString());
                p.setRut(rutTxt.getText().toString());
                p.setPresion(Integer.parseInt(presionTxt.getText().toString()));
                if (sintomas ==true){
                    p.setSintomas(1);
                }else {
                    p.setSintomas(0);
                }
                if (tos ==true){
                    p.setTos(1);
                }else{
                    p.setTos(0);
                }

                if(sintomas ==false || tos ==false){
                    p.setEstado(0);
                }else{
                    p.setEstado(1);
                }
                p.setArea(area);
                p.setFechaExamen(fecha);

                //dao
                pacientesDAO.guardar(p);

                //intent
                startActivity(new Intent(RegistroDePaciente.this,Principal.class));





            }
        });


        fechaTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(RegistroDePaciente.this, android.R.style.Widget_DeviceDefault,
                        nDateSetListener, dia, mes, year);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        nDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                mes = mes + 1;

                fecha = dia + "/" + mes + "/" + anio;
                fechaTxt.setText(fecha);

            }
        };

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         area = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onclick(View view) {

        if (view.getId() == R.id.sintomas) {
            if (view.getId() == R.id.sintomas) {
                sintomas = true;

            } else {
                sintomas = false;
            }
        }

        if (view.getId() == R.id.tos) {
            if (view.getId() == R.id.tos) {
                tos = true;
            } else {
                tos = false;
            }
        }
    }




}