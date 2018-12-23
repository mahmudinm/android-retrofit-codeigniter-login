package com.example.mahmudinm.androidcodeigniterlogin.api.response;

/**
 * Created by Mahmudinm on 23/12/2018.
 */

public class ResponseAuth {

    private String token, username, id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
