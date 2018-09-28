package com.example.admin.retrofitrealm.realmDB;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Admin on 26/09/2018.
 */

public class UsuarioModel extends RealmObject {

    @PrimaryKey
    private int id_usuario;
    private String nombre;
    private String email;


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
