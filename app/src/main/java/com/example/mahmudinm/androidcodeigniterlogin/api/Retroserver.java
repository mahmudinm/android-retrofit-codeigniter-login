package com.example.mahmudinm.androidcodeigniterlogin.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahmudinm on 23/12/2018.
 */

public class Retroserver {

    private static final String base_url = "https://dacaf3fc.ngrok.io/android_codeigniter_login/api/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
