package com.bier.myapplication.http;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSONObject;
import com.bier.myapplication.app.Constants;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private final Handler mHandler;
    private final OkHttpClient mClient;
    //声明类的变量
    private static volatile OkHttpUtils sOkHttpUtils;



    //私有构造
    private OkHttpUtils() {
        mHandler = new Handler(Looper.getMainLooper());
        mClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    //暴露外界访问的方法,双层锁
    public static OkHttpUtils getInstance(){
        if(sOkHttpUtils == null){
            synchronized (OkHttpUtils.class){
                if(sOkHttpUtils == null){
                    //创建对象
                    sOkHttpUtils = new OkHttpUtils();
                }
            }
        }

        return sOkHttpUtils;
    }
    public void doPost(String path, Map<String,String> map , final ApiCallback apiCallback ){

        //创建表单
        FormBody.Builder builder = new FormBody.Builder();

        if(map != null){
            for (String key : map.keySet() ) {
                //添加键值对
                builder.add(key,map.get(key));
            }
        }
        //完成表单的创建
        FormBody formBody = builder.build();

        Request request = new Request.Builder()
                .post(formBody)
                .url(Constants.BASE+path)
                .build();

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                JSONObject jsonObject=JSONObject.parseObject(string);
                apiCallback.success(jsonObject);
            }
        });

    }


}
