package com.example.mahmudinm.androidcodeigniterlogin.api;

import com.example.mahmudinm.androidcodeigniterlogin.api.response.ResponseAuth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Mahmudinm on 23/12/2018.
 */

public interface ApiRequest {

    @FormUrlEncoded
    @POST("auth")
    Call<ResponseAuth> authPost(@Field("username") String username,
                                @Field("password") String password);

}
