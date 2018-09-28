package com.example.admin.retrofitrealm.loginRetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.retrofitrealm.R;
import com.example.admin.retrofitrealm.retrofit.GetDataService;
import com.example.admin.retrofitrealm.retrofit.RetrofitClientInstance;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtPassword;
    Button btnLogin;

    private static final String BASE_URL = "https://agentemovil.pagatodo.com/AgenteMovil.svc/agMov/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);


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

                    LoginService(edtUsuario.getText().toString(), edtPassword.getText().toString());
                }
            }
        });

    }

    private void LoginService(String s, String p) {

        JsonObject jsonObject = new JsonObject();
        JsonObject jObject = new JsonObject();

        jObject.addProperty("user", s);
        jObject.addProperty("pass", p);
        jsonObject.add("data",jObject);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance(BASE_URL).create(GetDataService.class);

        Call<LoginModel> call = service.getLogin2(jsonObject);
        call.enqueue(new Callback<LoginModel>() {

            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(LoginModel body) {
        Log.d("RESULTADO", body.toString());
    }
}
