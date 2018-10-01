package com.example.admin.retrofitrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.retrofitrealm.fotos.view.MainActivity;
import com.example.admin.retrofitrealm.login.view.LoginActivity;
import com.example.admin.retrofitrealm.realmDB.UsuarioRealm;

public class Inicio extends AppCompatActivity {

    Button btnOffice;
    Button btnLogin;
    Button btnRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnOffice = findViewById(R.id.btnOffice);
        btnLogin = findViewById(R.id.btnLogin);
        btnRealm = findViewById(R.id.btnRealm);


        btnOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnRealm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, UsuarioRealm.class);
                startActivity(i);
            }
        });

    }
}
