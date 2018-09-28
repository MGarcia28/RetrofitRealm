package com.example.admin.retrofitrealm.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 28/08/2018.
 */
public class RetrofitClientInstance {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(String url) {

        if (retrofit == null) {
/*            HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
            loggin.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(loggin);*/

                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                //API_SERVICE = retrofit.create(GetDataService.class);
        }
        return retrofit;
    }
}

