package com.bier.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bier.myapplication.Baen.NewsBean;
import com.bier.myapplication.Baen.ResponseBaen;
import com.bier.myapplication.R;
import com.bier.myapplication.adapter.MainAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private Context mContext;
    private List<NewsBean> list;
    private MainAdapter mainAdapter;
    private ResponseBaen responseBaen;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    list.addAll(responseBaen.getData());
                    mainAdapter.notifyDataSetChanged();
                    break;
                    default:
                        break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        mContext = this;
        initData();
        apiData();
    }

    private void apiData() {
        Log.i("data117", Thread.currentThread().getName());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://wanandroid.com/wxarticle/chapters/json")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("data194", string);
                JSONObject object = JSONObject.parseObject(string);
                responseBaen = JSONObject.toJavaObject(object, ResponseBaen.class);
                handler.sendEmptyMessage(0);


            }
        });

    }

    private void initData() {
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(mContext, list);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initview() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                apiData();
                refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败


            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
                apiData();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }
}
