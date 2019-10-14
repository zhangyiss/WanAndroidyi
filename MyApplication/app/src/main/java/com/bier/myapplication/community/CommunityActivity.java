package com.bier.myapplication.community;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bier.myapplication.R;

/**
 * @author blbl
 * @date 2019/8/30
 */
public class CommunityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

    }

    @Override
    protected void onStart() {
        super.onStart();
       new Thread(){
           @Override
           public void run() {
               super.run();
           }
       }.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
