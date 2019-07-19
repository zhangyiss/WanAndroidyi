package com.bier.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONObject;
import com.bier.myapplication.Baen.BannerBaen;
import com.bier.myapplication.Baen.BannerBaenResponseBaen;
import com.bier.myapplication.Baen.TobListBaen;
import com.bier.myapplication.Baen.TobResponseBaen;
import com.bier.myapplication.EventBusBaen.MessageWrap;
import com.bier.myapplication.R;
import com.bier.myapplication.adapter.TobAdapter;
import com.bier.myapplication.view.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TabFragment extends Fragment {
    private BannerBaenResponseBaen bannerBaenResponseBaen;
    private Banner banner;
    private List<BannerBaen> listbanner;
    private TobResponseBaen tobResponseBaen;
    private RecyclerView recyclerView;
    private List<TobListBaen> list;
    private List<String> bannerList;
    TobAdapter tobAdapter;
    @SuppressLint("HandlerLeak")
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 0:
                    list.addAll(tobResponseBaen.getData());
                    tobAdapter.notifyDataSetChanged();
                    break;
                case 1:
                    listbanner = bannerBaenResponseBaen.getData();
                    bannerList = new ArrayList<>();
                    for (int i = 0; i < listbanner.size(); i++) {
                        bannerList.add(listbanner.get(i).getImagePath());
                    }
                    banner.setImages(bannerList);
                    banner.start();
                    break;
                    default:
                        break;
            }

        }
    };

    public static TabFragment newTnstance() {
        return new TabFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tob, container, false);
        EventBus.getDefault().register(this);
        initapi();
        initbanner();
        initview(view);
        return view;

    }

    private void initbanner() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/banner/json")
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("data287", string);
                JSONObject object = JSONObject.parseObject(string);
                bannerBaenResponseBaen = JSONObject.toJavaObject(object, BannerBaenResponseBaen.class);
                mhandler.sendEmptyMessage(1);
                Log.i("data145", Thread.currentThread().getName());


            }
        });

    }

    private void initview(View view) {
        list = new ArrayList<>();
        banner = (Banner) view.findViewById(R.id.banner);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutmanager);
        tobAdapter = new TobAdapter(getContext(), list);
        recyclerView.setAdapter(tobAdapter);

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


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetStickyEvent(MessageWrap message) {
        if ("refresh".equals(message.getType())) {
            initbanner();

        }

    }

    private void initapi() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/navi/json")
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("data119", e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("data121", string);
                JSONObject object = JSONObject.parseObject(string);
                tobResponseBaen = JSONObject.toJavaObject(object, TobResponseBaen.class);
                mhandler.sendEmptyMessage(0);


            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mhandler != null) {
            mhandler.removeCallbacksAndMessages(null);
        }
    }
}
