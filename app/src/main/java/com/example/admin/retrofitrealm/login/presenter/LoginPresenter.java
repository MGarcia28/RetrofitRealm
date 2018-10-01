package com.example.admin.retrofitrealm.login.presenter;

import com.example.admin.retrofitrealm.login.model.Login;

import retrofit2.Response;

/**
 * Created by Admin on 01/10/2018.
 */

public interface LoginPresenter {

    void getLoginData(String user, String pass);
    void loginCorrecto(Login user);
    void loginIncorrecto(String mensaje);
    void errorDeServicio(String mensaje);
}
