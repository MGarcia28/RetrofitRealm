package com.example.admin.retrofitrealm.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.retrofitrealm.R;
import com.example.admin.retrofitrealm.login.model.Login;
import com.example.admin.retrofitrealm.login.presenter.LoginPresenter;
import com.example.admin.retrofitrealm.login.presenter.LoginPresenterImp;

public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText edtUsuario;
    EditText edtPassword;
    Button btnLogin;
    private static final String BASE_URL = "https://agentemovil.pagatodo.com/AgenteMovil.svc/agMov/";


    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        loginPresenter = new LoginPresenterImp(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edtUsuario.setError(null);
                edtPassword.setError(null);

                String usuario = edtUsuario.getText().toString();
                String contrasenia = edtPassword.getText().toString();

                boolean cancel = false;
                View focusView = null;

                if (TextUtils.isEmpty(contrasenia)) {
                    edtPassword.setError(getString(R.string.error_contrasenia_invalida));
                    focusView = edtPassword;
                    cancel = true;
                }

                if (TextUtils.isEmpty(usuario)) {
                    edtUsuario.setError(getString(R.string.error_usuario_requerido));
                    focusView = edtUsuario;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                    return;
                } else {
                    loginData();
                }
            }
        });
    }


    @Override
    public void loginData() {
        loginPresenter.getLoginData(edtUsuario.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void loginCorrecto(Login user) {
        Toast.makeText(this, "Usuario: " + user.getAgente(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginIncorrecto(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorDeServicio(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}
