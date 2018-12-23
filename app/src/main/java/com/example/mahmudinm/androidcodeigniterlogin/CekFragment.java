package com.example.mahmudinm.androidcodeigniterlogin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mahmudinm.androidcodeigniterlogin.api.ApiRequest;
import com.example.mahmudinm.androidcodeigniterlogin.api.Retroserver;
import com.example.mahmudinm.androidcodeigniterlogin.api.response.ResponseStatus;
import com.example.mahmudinm.androidcodeigniterlogin.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CekFragment extends Fragment {

    Button cekAuth;
    SessionManager session;
    String status ;
    
    public CekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_cek, container, false);

        session = new SessionManager(getActivity());

        cekAuth = (Button) x.findViewById(R.id.cekAuth);

        cekAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiRequest api = Retroserver.getClient().create(ApiRequest.class);
                Call<ResponseStatus> getMain = api.getMain(session.getKeyToken());
//                Call<ResponseStatus> getMain = api.getMain("cobaerror");
                getMain.enqueue(new Callback<ResponseStatus>() {
                    @Override
                    public void onResponse(Call<ResponseStatus> call, Response<ResponseStatus> response) {
                        status = response.body().getStatus();
                        if (status.equals("ok")) {
                            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseStatus> call, Throwable t) {
                        Toast.makeText(getActivity(), "This Error", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        return x ;
    }

}
