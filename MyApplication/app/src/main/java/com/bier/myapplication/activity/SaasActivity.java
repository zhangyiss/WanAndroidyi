package com.bier.myapplication.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bier.myapplication.R;
import com.bier.myapplication.fragment.FirstFragment;

public class SaasActivity extends AppCompatActivity implements  FirstFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saas);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment fragment = new FirstFragment();
                Bundle bundle = new Bundle();
                bundle.putString("data","传递到的数据");
                fragment.setArguments(bundle);//数据传递到fragment中
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout,fragment);
                fragmentTransaction.commit();

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}
