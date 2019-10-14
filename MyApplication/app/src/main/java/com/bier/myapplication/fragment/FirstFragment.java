package com.bier.myapplication.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bier.myapplication.R;

/**
 * @author blbl
 * @date 2019/10/9
 */
public class FirstFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv);
        Bundle bundle=this.getArguments();
        String mess=null;
        if (bundle==null){
            mess=bundle.getString("data");
        }
        textView.setText(mess);
        return textView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    public  interface  OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri) ;
    }
}

