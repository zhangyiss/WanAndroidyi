package com.bier.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bier.myapplication.Baen.BannerBaen;
import com.bier.myapplication.Baen.BannerBaenResponseBaen;
import com.bier.myapplication.Baen.ListBaen;
import com.bier.myapplication.Baen.ListResponseBaen;
import com.bier.myapplication.EventBusBaen.MessageWrap;
import com.bier.myapplication.R;
import com.bier.myapplication.adapter.ListAdapter;
import com.bier.myapplication.adapter.TabLayoutViewPageAdapter;
import com.bier.myapplication.view.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NesFragment extends Fragment {
    private TabLayout tabLayout;
    private LinearLayout lay_title;
    private RecyclerView recyclerView;
    private Banner banner;
    private BannerBaenResponseBaen bannerBaenResponseBaen;
    private ListResponseBaen listResponseBaen;
    private List<BannerBaen> listbanner;
    private List<String> bannerList;
    private ListAdapter listAdapter;
    private TabHomeFragment mContext;
    private List<ListBaen> list;

    @SuppressLint("HandlerLeak")
    private Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    listbanner = bannerBaenResponseBaen.getData();
                    bannerList = new ArrayList<>();
                    for (int i = 0; i < listbanner.size(); i++) {
                        bannerList.add(listbanner.get(i).getImagePath());
                    }
                    banner.setImages(bannerList);
                    banner.start();
                    break;
                case 1:
                    list.addAll(listResponseBaen.getData());

            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        initview(view);
        initData();
        initapi();
        return view;
    }

    public  static NesFragment newTnstance(){
        return new NesFragment();
    }

    private void initapi() {
        Log.i("data101",Thread.currentThread().getName());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.wanandroid.com//hotkey/json")
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                JSONObject object = JSONObject.parseObject(s);
                listResponseBaen = JSONObject.toJavaObject(object, ListResponseBaen.class);
                mhandler.sendEmptyMessage(1);

                Log.i("data111",Thread.currentThread().getName());


            }
        });
    }

    private void initData() {
        OkHttpClient client = new OkHttpClient();
         Request request=new Request.Builder()
                 .url("https://www.wanandroid.com/banner/json")
                 .get()
                 .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                  Log.i("data287",string);
                  JSONObject object= JSONObject.parseObject(string);
                  bannerBaenResponseBaen = JSONObject.toJavaObject(object, BannerBaenResponseBaen.class);
                  mhandler.sendEmptyMessage(0);
                Log.i("data145",Thread.currentThread().getName());
                EventBus.getDefault().post(new MessageWrap("refresh"));
                //TODO EventBus 发送事件

            }
        });
    }

    private void initview(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        list = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutmanager);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        listAdapter = new ListAdapter(getContext(), list);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        banner = (Banner) view.findViewById(R.id.banner);

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mhandler!=null){
            mhandler.removeCallbacksAndMessages(null);
        }
    }
}
