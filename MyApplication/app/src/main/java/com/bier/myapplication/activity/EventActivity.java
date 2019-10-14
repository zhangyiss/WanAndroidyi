package com.bier.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bier.myapplication.Baen.CollectEvent;
import com.bier.myapplication.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

/**
 * @author blbl
 * @date 2019/9/10
 */
public class EventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        initApi();
    }

    private void initApi() {
        HashMap map=new HashMap();
        map.put("","");
        map.put("","");
        map.put("","");
        map.put("","");
        map.put("","");


    }

}
