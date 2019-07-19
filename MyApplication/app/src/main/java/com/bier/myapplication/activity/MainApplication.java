package com.bier.myapplication.activity;

import android.app.Application;
import android.widget.ShareActionProvider;

import java.util.HashMap;

public class MainApplication extends Application {

    private  static   MainApplication mApp;
    public HashMap<String,String>mInfoMaP=new HashMap<String, String>();

    public static  MainApplication getInstance(){
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
    }
}
