package com.bier.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bier.myapplication.Baen.BannerBaen;
import com.bier.myapplication.Baen.BannerBeanResponseBaen;
import com.bier.myapplication.Baen.ListBaen;
import com.bier.myapplication.Baen.ListResponseBaen;
import com.bier.myapplication.R;
import com.bier.myapplication.adapter.ListAdapter;
import com.bier.myapplication.view.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Banner banner;
    private BannerBeanResponseBaen bannerBaenResponseBaen;
    private ListResponseBaen listResponseBaen;
    private List<BannerBaen> Listbanner;
    private List<String> bannerList;
    private ListAdapter listAdapter;
    private Context mContext;
    private List<ListBaen> list;
    @SuppressLint("HandlerLeak")
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Listbanner = bannerBaenResponseBaen.getData();
                    bannerList = new ArrayList<>();
                    for (int i = 0; i < Listbanner.size(); i++) {
                        bannerList.add(Listbanner.get(i).getImagePath());
                    }
                    banner.setImages(bannerList);
                    banner.start();
                    break;
                case 1:
                    list.addAll(listResponseBaen.getData());
                    listAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        iniView();
        initlist();
        mContext = this;
        InitData();
        initApi();

    }

    private void initlist() {
        list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        listAdapter = new ListAdapter(mContext, list);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.findViewHolderForItemId(0);
    }

    private void initApi() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://www.wanandroid.com//hotkey/json")
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("data118", Thread.currentThread().getName());
                String s = response.body().string();
                Log.i("data446", s);
                JSONObject object = JSONObject.parseObject(s);
                listResponseBaen = JSONObject.toJavaObject(object, ListResponseBaen.class);
                mhandler.sendEmptyMessage(1);
            }
        });
    }

    private void iniView() {
        banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
//        banner.start();
    }

    private void InitData() {
        Log.i("data116", Thread.currentThread().getName());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://www.wanandroid.com/banner/json")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (!TextUtils.isEmpty(e.getMessage())) {
                    Toast.makeText(ListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                JSONObject object = JSONObject.parseObject(s);
                bannerBaenResponseBaen = JSONObject.toJavaObject(object, BannerBeanResponseBaen.class);
                mhandler.sendEmptyMessage(0);


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mhandler != null) {
            mhandler.removeCallbacksAndMessages(null);
        }
    }


}
