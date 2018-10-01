package com.example.admin.retrofitrealm.login.presenter;

import android.content.Context;

import com.example.admin.retrofitrealm.login.interactor.LoginInteractor;
import com.example.admin.retrofitrealm.login.interactor.LoginInteractorImp;
import com.example.admin.retrofitrealm.login.model.Login;
import com.example.admin.retrofitrealm.login.view.LoginView;

/**
 * Created by Admin on 01/10/2018.
 */

public class LoginPresenterImp implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImp(this);
    }

    @Override
    public void getLoginData(String user, String pass) {
        loginInteractor.loginData(user, pass);
    }

    @Override
    public void loginCorrecto(Login user) {
        loginView.loginCorrecto(user);
    }

    @Override
    public void loginIncorrecto(String mensaje) {
        loginView.loginIncorrecto(mensaje);
    }

    @Override
    public void errorDeServicio(String mensaje) {
        loginView.errorDeServicio(mensaje);
    }
}
