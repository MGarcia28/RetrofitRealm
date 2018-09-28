package com.example.admin.retrofitrealm.retrofit;

import com.example.admin.retrofitrealm.loginRetrofit.LoginModel;
import com.example.admin.retrofitrealm.fotosRealm.RetroPhoto;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Admin on 28/08/2018.
 */

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();



/*    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "SO : Android",
            "Version : 2.5.2"})
    @POST("login")
    Call<JSONObject> getLogin2(@Body JsonObject jsonObject);*/


/*    @Headers({
            "Content-type: application/json",
            "SO: Android",
            "Version:2.5.2"
    })
    @POST("login")
    Call<JSONObject> getLogin2(@Body JsonObject jsonObject);*/



    @Headers({
            "Content-type: application/json",
            "SO: Android",
            "Version:2.5.2"
    })
    @POST("login")
    Call<LoginModel> getLogin2(@Body JsonObject loginModel);

}

