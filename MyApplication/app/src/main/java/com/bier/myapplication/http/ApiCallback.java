package com.bier.myapplication.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import okhttp3.Response;

public interface ApiCallback {

    void success(JSONObject jsonObject );


    void failure(IOException e);
}
