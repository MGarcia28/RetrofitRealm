package com.example.admin.retrofitrealm.login.view;

import com.example.admin.retrofitrealm.login.model.Login;

/**
 * Created by Admin on 01/10/2018.
 */

public interface LoginView {

    void loginData();
    void loginCorrecto(Login user);
    void loginIncorrecto(String mensaje);
    void errorDeServicio(String mensaje);
}
