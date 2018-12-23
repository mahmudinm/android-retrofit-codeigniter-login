package com.example.mahmudinm.androidcodeigniterlogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahmudinm.androidcodeigniterlogin.api.ApiRequest;
import com.example.mahmudinm.androidcodeigniterlogin.api.Retroserver;
import com.example.mahmudinm.androidcodeigniterlogin.api.response.ResponseAuth;
import com.example.mahmudinm.androidcodeigniterlogin.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    String username, password;
    Button login;
    ProgressDialog progressDialog;
    ConnectivityManager conMgr;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "NO INTERNET CONNECTION", Toast
                        .LENGTH_LONG).show();
            }
        }

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();

                ApiRequest api = Retroserver.getClient().create(ApiRequest.class);
                Call<ResponseAuth> authPost = api.authPost(username, password);
                authPost.enqueue(new Callback<ResponseAuth>() {
                    @Override
                    public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                        progressDialog.dismiss();
                        session.createLoginSession(
                                response.body().getId(),
                                response.body().getUsername(),
                                "Bearer " + response.body().getToken()
                        );
                        finish();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<ResponseAuth> call, Throwable t) {
                        progressDialog.dismiss();

                    }
                });

            }
        });

    }
}
