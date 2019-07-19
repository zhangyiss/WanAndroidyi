package com.bier.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bier.myapplication.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phoe;
    private  EditText sms;
    private Button  btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniview();





    }

    private void iapData() {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody=new FormBody.Builder()
                .add("username","18062219028")
                .add("password","123456")
                .build();
        Request request=new Request.Builder()
                .post(formBody)
                .url("https://www.wanandroid.com/user/login")
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("data",e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("data615",string);

            }
        });


    }

    private void iniview() {
        phoe = (EditText) findViewById(R.id.phoe);
        sms = (EditText) findViewById(R.id.sms);
         btn = (Button) findViewById(R.id.btn);
         btn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                iapData();
                Intent intent = new Intent();
                intent.setClass(this,MainActivity.class);
                startActivity(intent);


        }

    }
}
