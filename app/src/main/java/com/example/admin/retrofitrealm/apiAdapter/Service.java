package com.example.admin.retrofitrealm.apiAdapter;

import com.example.admin.retrofitrealm.fotos.RetroPhoto;
import com.example.admin.retrofitrealm.login.model.Login;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Admin on 01/10/2018.
 */

public interface Service {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @Headers({
            "Content-type: application/json",
            "SO: Android",
            "Version:2.5.2"
    })
    @POST("login")
    Call<Login> getLogin2(@Body JsonObject loginModel);
}
