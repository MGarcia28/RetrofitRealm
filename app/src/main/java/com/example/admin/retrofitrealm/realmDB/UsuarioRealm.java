package com.example.admin.retrofitrealm.realmDB;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.retrofitrealm.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class UsuarioRealm extends AppCompatActivity {

    private Button btnGuardar;
    private Button btnConsultar;
    private Button btnActualizar;
    private Button btnEliminar;

    private EditText edtID;
    private EditText edtAgente;
    private EditText edtToken;

    ServicioLogin servicioLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_realm);

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("UsuarioDB")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        servicioLogin = new ServicioLogin(Realm.getDefaultInstance());



        edtID = findViewById(R.id.edtID);
        edtAgente = findViewById(R.id.edtAgente);
        edtToken = findViewById(R.id.edtToken);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarUsuario();
            }
        });

        btnConsultar = findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtID.getText().toString().isEmpty()) {
                    consultarUsuario();
                } else {
                    consultaUsiarioPorId();
                }
            }
        });

        btnActualizar = findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarUsuario();
            }
        });

        btnEliminar = findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarUsuario();
            }
        });
    }

    private void eliminarUsuario() {
        servicioLogin.eliminarUsuario(Integer.valueOf(String.valueOf(edtID.getText())));

    }

    private void actualizarUsuario() {

        UsuarioModel usuarioM = consultaUsiarioPorId();

        String usuario = edtAgente.getText().toString().isEmpty() ? usuarioM.getNombre() : edtAgente.getText().toString();
        String mail = edtToken.getText().toString().isEmpty() ? usuarioM.getEmail() : edtToken.getText().toString();

        servicioLogin.actualizarUsuario(usuarioM, usuario, mail);
    }


    private void consultarUsuario() {
        UsuarioModel[] usuarioModels = servicioLogin.obtenerUsuario();

        for (UsuarioModel usuario: usuarioModels){
            Log.d("RESULT:" , "ID " + usuario.getId_usuario() +
                            " NOMBRE " + usuario.getNombre() +
                            " EMAIL " + usuario.getEmail() + "\n");
        }
    }

    private UsuarioModel consultaUsiarioPorId() {

        UsuarioModel usuarioModel = servicioLogin.obtenerUsuarioPorID(Integer.valueOf(String.valueOf(edtID.getText())));
        Log.d("USUARIO ", usuarioModel.getNombre());

        return  usuarioModel;
    }

    private void guardarUsuario() {
        servicioLogin.crearUsuario(Integer.valueOf(String.valueOf(edtID.getText())), edtAgente.getText().toString(),edtToken.getText().toString());
    }


}
