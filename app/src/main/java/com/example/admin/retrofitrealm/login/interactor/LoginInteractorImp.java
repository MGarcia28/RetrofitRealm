package com.example.admin.retrofitrealm.login.interactor;

import com.example.admin.retrofitrealm.login.presenter.LoginPresenter;
import com.example.admin.retrofitrealm.login.repository.LoginRepository;
import com.example.admin.retrofitrealm.login.repository.LoginRepositoryImp;

/**
 * Created by Admin on 01/10/2018.
 */

public class LoginInteractorImp implements LoginInteractor {

    private LoginPresenter loginPresenter;
    private LoginRepository loginRepository;

    public LoginInteractorImp(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        loginRepository = new LoginRepositoryImp(loginPresenter);
    }


    @Override
    public void loginData(String user, String pass) {
        loginRepository.loginData(user, pass);
    }
}
