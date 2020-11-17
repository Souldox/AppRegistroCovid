package com.example.appregistrocovid;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button login;
    EditText usuario, password;
    String Usuario, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.login = findViewById(R.id.btnLogin);
        this.usuario = findViewById(R.id.usuario);
        this.password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario = usuario.getText().toString();
                Password = password.getText().toString();

                if (Usuario.matches("Admin") && Password.matches("admin")) {
                    Intent intent = new Intent(MainActivity.this, Principal.class);
                    startActivity(intent);
                } else {
                    usuario.setBackgroundColor(Color.RED);
                    password.setBackgroundColor(Color.RED);
                    Toast.makeText(MainActivity.this, "Los Datos ingresados no son validos", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
