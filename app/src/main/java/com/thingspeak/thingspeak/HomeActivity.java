package com.thingspeak.thingspeak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.thingspeak.thingspeak.adapter.ChannelAdapter;
import com.thingspeak.thingspeak.adapter.HomeAdapter;
import com.thingspeak.thingspeak.databinding.ActivityHomeBinding;
import com.thingspeak.thingspeak.listeners.ItemSelecetedListener;
import com.thingspeak.thingspeak.model.Channel;
import com.thingspeak.thingspeak.model.Feed;
import com.thingspeak.thingspeak.model.Feed_Temp;
import com.thingspeak.thingspeak.model.Home_model;
import com.thingspeak.thingspeak.model.User;
import com.thingspeak.thingspeak.utils.DateUtils;
import com.thingspeak.thingspeak.utils.ProgressUtill;
import com.thingspeak.thingspeak.utils.SharedPrefManager;
import com.thingspeak.thingspeak.utils.SimpleDividerItemDecoration;
import com.thingspeak.thingspeak.viewmodel.ChannelViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ItemSelecetedListener {
    ActivityHomeBinding binding;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        user =SharedPrefManager.getSharedPrefInstance(getApplicationContext()).getUserData();
        binding.textViewUsername.setText("Name: "+user.getName());
        ProgressUtill.showProgess(getApplicationContext(),binding.linearLayout5);

        loadData();
        binding.TDStextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,MainActivity.class);
                intent.putExtra("ID","1");
                startActivity(intent);
            }
        });
        binding.PHtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,MainActivity.class);
                intent.putExtra("ID","2");
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        ChannelViewModel channelViewModel = new ViewModelProvider(this).get(ChannelViewModel.class);
        channelViewModel.getAllFeeds().observe(this, list -> {
            ProgressUtill.hideProgess(getApplicationContext());
            if (list!=null) {
                String tds = list.get(list.size() - 2).getField1().trim();
                binding.textViewTdsValue.setText(tds.substring(0,4).trim());
                binding.textViewLastSynDate.setText("Last Sync: " + DateUtils.getDateTime(list.get(list.size() - 2).getCreated_at()));
            }
        });
        channelViewModel.getChannel().observe(this, new Observer<Channel>() {
            @Override
            public void onChanged(Channel channel) {
                binding.textViewRole.setText("Chanel Id: "+String.valueOf(channel.getId()));
                binding.textViewMobile.setText("Channel Name: "+channel.getName());
                //String str= channel.getCreated_at();
                // MainActivity.date_title.setText(DateUtils.getDate(str));
            }
        });
        channelViewModel.getTempFeeds().observe(this, new Observer<List<Feed_Temp>>() {
            @Override
            public void onChanged(List<Feed_Temp> feed_temps) {
            binding.textViewTempValue.setText(feed_temps.get(feed_temps.size()-1).getField1().trim().substring(0,4));
            binding.textViewHmValue.setText(feed_temps.get(feed_temps.size()-1).getField2().trim().substring(0,4));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
       // loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            SharedPrefManager.getSharedPrefInstance(getApplicationContext()).isLogedout();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
    }
}