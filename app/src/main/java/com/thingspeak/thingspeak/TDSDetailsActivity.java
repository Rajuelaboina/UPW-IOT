package com.thingspeak.thingspeak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.TextView;
import com.thingspeak.thingspeak.viewmodel.ChannelViewModel;

public class TDSDetailsActivity extends AppCompatActivity {
   TextView tv_tdsChName,tv_tdsChID;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdsdetails);
        tv_tdsChName=findViewById(R.id.textViewTds_ChName);
        tv_tdsChID =findViewById(R.id.textView_tdsChID);
        ChannelViewModel channelViewModel = new ViewModelProvider(this).get(ChannelViewModel.class);
        channelViewModel.getChannel().observe(this, channel -> {
            tv_tdsChName.setText(channel.getName());
            tv_tdsChID.setText(String.valueOf(channel.getId()));
        });
    }
}