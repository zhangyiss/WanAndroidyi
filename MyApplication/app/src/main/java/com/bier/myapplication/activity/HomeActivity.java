package com.bier.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bier.myapplication.R;
import com.bier.myapplication.fragment.NesFragment;
import com.bier.myapplication.fragment.TabHomeFragment;
import com.bier.myapplication.fragment.TabMyFragment;
import com.bier.myapplication.fragment.TabFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout nav1, nav2, nav3;
    private ImageView navImg1, navImg3;
    private TextView navTv1, navTv3;
    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();


    /**
     * 首页
     */

    private final int TAB_HOME = 0;

    /**
     * 玩玩
     */

    private final int TAB_WW = 1;


    /**
     * 我的
     */

    private final int TAB_MY = 2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        initview();
    }

    private void initview() {
        nav1 = findViewById(R.id.nav1);
        nav2 = findViewById(R.id.nav2);
        nav3 = findViewById(R.id.nav3);
        navImg1 = findViewById(R.id.navImg1);
        navImg3 = findViewById(R.id.navImg3);
        navTv1 = findViewById(R.id.navTv1);
        navTv3 = findViewById(R.id.navTv3);
        viewPager = findViewById(R.id.viewpager);
        fragmentList.add(TabHomeFragment.newInstance());
        fragmentList.add(TabFragment.newTnstance());
        fragmentList.add(TabMyFragment.newTnstance());
        viewPager.setOffscreenPageLimit(fragmentList.size());



        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nav1:
                switchTab(nav1);
                viewPager.setCurrentItem(TAB_HOME, false);
                break;
            case R.id.nav2:
                switchTab(nav2);
                viewPager.setCurrentItem(TAB_WW, false);
                break;
            case R.id.nav3:
                switchTab(nav3);
                viewPager.setCurrentItem(TAB_MY, false);
                break;
            default:
                break;

        }

    }

    private void switchTab(View view) {
        navImg1.setImageResource(view.getId() == R.id.nav1 ? R.drawable.liaochang : R.drawable.liaochang_gray);
        navTv1.setSelected(view.getId() == R.id.nav1);
        navImg3.setImageResource(view.getId() == R.id.nav3 ? R.mipmap.my_active : R.drawable.wo_grey);
        navTv3.setSelected(view.getId() == R.id.nav3);


    }

}
