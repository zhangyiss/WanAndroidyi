package com.bier.myapplication.activity;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bier.myapplication.R;
import com.ldoublem.thumbUplib.ThumbUpView;

public class GivetheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givethe);
        initview();
    }

    private void initview() {
        ThumbUpView mThumbUpView = (ThumbUpView) findViewById(R.id.tpv);
        mThumbUpView.setUnLikeType(ThumbUpView.LikeType.broken);
        mThumbUpView.setCracksColor(Color.rgb(22, 33, 44));
        mThumbUpView.setFillColor(Color.rgb(11, 200, 77));
        mThumbUpView.setEdgeColor(Color.rgb(33, 3, 219));

        mThumbUpView.setOnThumbUp(new ThumbUpView.OnThumbUp() {
            @Override
            public void like(boolean like) {
                if (like == true) {
                    Toast.makeText(GivetheActivity.this, "点赞", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GivetheActivity.this, "取消点赞", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
