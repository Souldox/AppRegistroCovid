package com.example.appregistrocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appregistrocovid.DTO.Paciente;

public class vistaPaciente extends AppCompatActivity {

    Paciente paciente;
    ImageView imgEstado;
    TextView detalleNombre;
    TextView detalleApellido;
    TextView detalleRut;
    TextView detalleSintomas;
    TextView detalleTos;
    TextView detallePresion;
    TextView detalleArea;
    TextView detalleFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_paciente);

        
        this.detalleNombre = findViewById(R.id.detalleNombre);
        this.detalleApellido = findViewById(R.id.detalleApellido);
        this.detalleRut = findViewById(R.id.detalleRut);
        this.detalleSintomas = findViewById(R.id.detalleSintomas);
        this.detalleTos = findViewById(R.id.detalleTos);
        this.detallePresion = findViewById(R.id.detallePresion);
        this.detalleArea = findViewById(R.id.detalleArea);
        this.detalleFecha = findViewById(R.id.detalleFecha);
        this.imgEstado = findViewById(R.id.imgEstado);

        this.paciente = (Paciente) getIntent().getSerializableExtra("paciente");
        this.detalleNombre.setText(this.paciente.getNombre());
        this.detalleApellido.setText(this.paciente.getApellido());
        this.detalleRut.setText(this.paciente.getRut());
        this.detalleSintomas.setText(this.paciente.getSintomas());
        this.detalleTos.setText(this.paciente.getTos());
        this.detallePresion.setText(this.paciente.getPresion());
        this.detalleArea.setText(this.paciente.getArea());
        this.detalleFecha.setText(this.paciente.getFechaExamen());

        this.imgEstado.setImageResource(this.paciente.getEstado());
        //TODO imagen ...




    }
}