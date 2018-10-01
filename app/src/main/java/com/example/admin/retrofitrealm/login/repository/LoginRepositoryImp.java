package com.example.admin.retrofitrealm.login.repository;

import com.example.admin.retrofitrealm.apiAdapter.ResApiAdapter;
import com.example.admin.retrofitrealm.apiAdapter.Service;
import com.example.admin.retrofitrealm.login.model.Login;
import com.example.admin.retrofitrealm.login.presenter.LoginPresenter;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 01/10/2018.
 */

public class LoginRepositoryImp implements LoginRepository {

    private static final String BASE_URL = "https://agentemovil.pagatodo.com/AgenteMovil.svc/agMov/";
    private LoginPresenter loginPresenter;

    public LoginRepositoryImp(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }


    @Override
    public void loginData(String user, String pass) {

        final JsonObject jsonObject = new JsonObject();
        JsonObject jObject = new JsonObject();

        jObject.addProperty("user", user);
        jObject.addProperty("pass", pass);
        jsonObject.add("data",jObject);

        Service service = ResApiAdapter.getRetrofitInstance(BASE_URL).create(Service.class);

        Call<Login> call = service.getLogin2(jsonObject);
        call.enqueue(new Callback<Login>() {

            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                Login usuario = response.body();

                if (usuario.getError() == null) {
                    loginPresenter.loginCorrecto(usuario);
                } else {
                    loginPresenter.loginIncorrecto(usuario.getError().getMessage());
                }

                /*
                    JsonObject jsonObject = response.body().getAsJspnObject("nom_arreglo");
                    Login userLogin = new Login(
                            jsonObject.get("Agente").getAsString();
                            jsonObject.get("id_user").getAsString();
                            jsonObject.get("error").getAsString();
                            jsonObject.get("token").getAsString();

                    );
                */

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
               loginPresenter.errorDeServicio("Servicio no disponible, Intente mas tarde");
            }
        });

    }
}
