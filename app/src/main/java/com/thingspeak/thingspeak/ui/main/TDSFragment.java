package com.thingspeak.thingspeak.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.thingspeak.thingspeak.TDSDetailsActivity;
import com.thingspeak.thingspeak.databinding.FragmentTdsBinding;
import com.thingspeak.thingspeak.listeners.ItemSelecetedListener;
import com.thingspeak.thingspeak.model.Feed_Temp;
import com.thingspeak.thingspeak.utils.DateUtils;
import com.thingspeak.thingspeak.MainActivity;
import com.thingspeak.thingspeak.R;
import com.thingspeak.thingspeak.utils.SimpleDividerItemDecoration;
import com.thingspeak.thingspeak.adapter.ChannelAdapter;
import com.thingspeak.thingspeak.model.Channel;
import com.thingspeak.thingspeak.model.Feed;
import com.thingspeak.thingspeak.viewmodel.ChannelViewModel;

import java.util.List;

public class TDSFragment extends Fragment implements ItemSelecetedListener {
    private RecyclerView recyclerView;
   public static ProgressBar progressBar;
   FragmentTdsBinding binding;
    public TDSFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }


    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tds, container, false);

    }
    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar=view.findViewById(R.id.progressBar);
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ChannelViewModel channelViewModel = new ViewModelProvider(this).get(ChannelViewModel.class);
        channelViewModel.getAllFeeds().observe(this, list -> {
            progressBar.setVisibility(View.GONE);
            Log.e("name", "Name <<<< : " + list.get(0).getField1());
            ChannelAdapter adapter = new ChannelAdapter(list, getContext(),this);
            recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
            recyclerView.setAdapter(adapter);

        });
        channelViewModel.getChannel().observe(this, new Observer<Channel>() {
            @Override
            public void onChanged(Channel channel) {
                String str= channel.getCreated_at();
                MainActivity.date_title.setText(DateUtils.getDate(str));
            }
        });


    }


    @Override
    public void onItemClick(int position) {
       // startActivity(new Intent(getContext(), TDSDetailsActivity.class));
    }
}