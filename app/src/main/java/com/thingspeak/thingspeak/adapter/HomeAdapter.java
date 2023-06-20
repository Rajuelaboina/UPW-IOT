package com.thingspeak.thingspeak.adapter;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thingspeak.thingspeak.R;
import com.thingspeak.thingspeak.listeners.ItemSelecetedListener;
import com.thingspeak.thingspeak.model.Home_model;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    List<Home_model> list;
    ItemSelecetedListener itemSelecetedListener;
    public HomeAdapter(List<Home_model> list, ItemSelecetedListener itemSelecetedListener) {
        this.list=list;
        this.itemSelecetedListener=itemSelecetedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_rowitem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
      holder.img.setImageResource(list.get(position).getImage());
      holder.tv.setText(list.get(position).getName());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              itemSelecetedListener.onItemClick(position);
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
         ImageView img;
         TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView_home);
            tv=itemView.findViewById(R.id.textView_home);
        }
    }
}
