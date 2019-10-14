package com.bier.myapplication.http;

import java.util.HashMap;
import java.util.Map;

public class ApiManager {
    public static void getBanner (ApiCallback apiCallback){
        OkHttpUtils.getInstance().doPost("/banner/json",new HashMap<>(),apiCallback);

    }

}
