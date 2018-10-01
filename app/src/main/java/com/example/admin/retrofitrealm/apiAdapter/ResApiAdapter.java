package com.example.admin.retrofitrealm.apiAdapter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 01/10/2018.
 */

public class ResApiAdapter {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(String url) {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
