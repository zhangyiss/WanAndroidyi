package com.bier.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bier.myapplication.Baen.ListBaen;
import com.bier.myapplication.R;

import java.lang.reflect.Type;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter <ListAdapter.ListViewHolder>{

    private List<ListBaen> ItimList;
    private Context mContext;

    public ListAdapter(Context context, List<ListBaen>ItimList){
        this.ItimList=ItimList;
        this.mContext=context;
  ;



    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.text_lists.setText(ItimList.get(position).getName());

    }



    @Override
    public int getItemCount() {
        return ItimList.size();
    }

    public class ListViewHolder extends  RecyclerView.ViewHolder {
        private  TextView text_lists;
        private LinearLayout jump;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            text_lists=itemView.findViewById(R.id.text_lists);
            jump=itemView.findViewById(R.id.jump);


        }
    }
}
