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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.bier.myapplication.R;
import com.bier.myapplication.adapter.TabLayoutViewPageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TabHomeFragment extends Fragment {
    private TabLayout tabLayout;
    private  ViewPager viewPager;
    List<Fragment>listFragment=new ArrayList<>();
    private final String[] titles = {"最新", "热门", "我的"};
    public static TabHomeFragment newInstance() {
        return new TabHomeFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initview(view);
        return view;
    }

    private void initview(View view) {
        ArrayList<String> titleList = new ArrayList<>(Arrays.asList(titles));
        listFragment.add(NesFragment.newTnstance());
        listFragment.add(TabFragment.newTnstance());
        listFragment.add(TabMyFragment.newTnstance());
        TabLayoutViewPageAdapter adapter = new TabLayoutViewPageAdapter(
                getChildFragmentManager(),
                getActivity(),
                listFragment,
                titleList);

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout.setTabMode(TabLayout.GRAVITY_CENTER);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(adapter);

    }

}



