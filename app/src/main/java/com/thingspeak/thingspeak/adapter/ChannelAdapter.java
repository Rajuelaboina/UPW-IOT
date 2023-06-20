package com.thingspeak.thingspeak.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.thingspeak.thingspeak.listeners.ItemSelecetedListener;
import com.thingspeak.thingspeak.utils.DateUtils;
import com.thingspeak.thingspeak.R;
import com.thingspeak.thingspeak.model.Feed;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder> {
    List<Feed> list;
    Context mContext;
    ItemSelecetedListener itemSelecetedListener;
    public ChannelAdapter(List<Feed> list, Context applicationContext, ItemSelecetedListener itemSelecetedListener) {
        this.list=list;
        this.mContext=applicationContext;
        this.itemSelecetedListener=itemSelecetedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //Date  date= dateFormat.parse(list.get(position).getCreated_at());
         String str=list.get(position).getCreated_at();
        holder.tv1.setText(DateUtils.getCurrentTime(str).trim());
        holder.tv2.setText(list.get(position).getField1().trim());
      //  holder.tv3.setText(list.get(position).getField1());
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

    protected static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.textView_created_at);
            tv2=itemView.findViewById(R.id.textView_feed);
           // tv3=itemView.findViewById(R.id.textView_status);
        }
    }
}
