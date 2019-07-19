package com.bier.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bier.myapplication.Baen.TobBaen;
import com.bier.myapplication.Baen.TobListBaen;
import com.bier.myapplication.R;

import java.util.List;

public class TobAdapter extends RecyclerView .Adapter<TobAdapter.TobHolder>{
    private List<TobListBaen>Itemlist;
    private Context mContext;

    public TobAdapter(Context context, List<TobListBaen> Itemlist){
        this.Itemlist=Itemlist;
        this.mContext=context;

    }

    @NonNull
    @Override
    public TobAdapter.TobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tob, parent, false);
        return new TobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TobAdapter.TobHolder holder, int position) {
        holder.name.setText(Itemlist.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return Itemlist.size();
    }

    public class TobHolder extends RecyclerView.ViewHolder {
        TextView name;
        public TobHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
