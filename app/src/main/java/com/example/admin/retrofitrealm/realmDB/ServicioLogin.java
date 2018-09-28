package com.example.admin.retrofitrealm.realmDB;


import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Admin on 26/09/2018.
 */

public class ServicioLogin {

    private Realm realm;
    public ServicioLogin(Realm realm) {
        this.realm = realm;
    }

    /**
    * OBTENER USUARIO
    */
    public UsuarioModel[] obtenerUsuario(){

        RealmResults<UsuarioModel> results = realm.where(UsuarioModel.class).findAll();

        return results.toArray(new UsuarioModel[results.size()]);
    }

    /**
     * OBTENER USUARIO POR ID
     */
    public UsuarioModel obtenerUsuarioPorID(int id) {

        UsuarioModel usuario = realm.where(UsuarioModel.class).equalTo("id_usuario", id).findFirst();

        return usuario;
    }

    /**
     * ACTUALIZAR
     */
    public void actualizarUsuario(UsuarioModel usuario, String nombre, String email) {

        realm.beginTransaction();
            usuario.setNombre(nombre);
            usuario.setEmail(email);
        realm.commitTransaction();

    }

    /**
     * GUARDAR
     */
    public void crearUsuario (int id, String nombre, String email) {

        realm.beginTransaction();

        UsuarioModel usuarioM = realm.createObject(UsuarioModel.class, id);
            usuarioM.setNombre(nombre);
            usuarioM.setEmail(email);
        realm.commitTransaction();
    }

    /**
     * ELIMINAR
     */
    public void eliminarUsuario(int id) {

        UsuarioModel usuarioModel = obtenerUsuarioPorID(id);

        if (!usuarioModel.getNombre().isEmpty()) {
            realm.beginTransaction();
            usuarioModel.deleteFromRealm();
            realm.commitTransaction();
        }
    }
}
