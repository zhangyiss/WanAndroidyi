package com.bier.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bier.myapplication.Baen.NewsBean;
import com.bier.myapplication.R;
import com.bier.myapplication.activity.ListActivity;
import com.bier.myapplication.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<NewsBean>  IiemList;
    private Context mContext;
    public  MainAdapter(Context context, List<NewsBean> IiemList){
        this.IiemList=IiemList;
        this.mContext=context;

    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        MainViewHolder mainViewHolder=new MainViewHolder(view);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.txtTitle.setText(IiemList.get(position).getName());
        holder.dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext, ListActivity.class);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return IiemList.size();
    }
    public class  MainViewHolder extends RecyclerView.ViewHolder{
        TextView  txtTitle;
        ImageView imgtp;
        LinearLayout dj;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txt_title);
            imgtp=itemView.findViewById(R.id.tp);
            dj=itemView.findViewById(R.id.dj);


        }
    }
}
