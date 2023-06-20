package com.thingspeak.thingspeak;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import com.thingspeak.thingspeak.ui.main.SectionsPagerAdapter;
import com.thingspeak.thingspeak.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   public static TextView date_title;
    private ActivityMainBinding binding;
    SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        date_title=binding.dateTitle;

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        //TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
      // String CountryID= manager.getSimCountryIso().toUpperCase();
       // Log.e("Code","<>><<><<<>: "+CountryID);
       // Log.e("Code","<>><<><<<>: "+ manager.);
        String id=getIntent().getStringExtra("ID");
        if (id.equals("1")){
            tabs.getTabAt(0).select();
        }else if (id.equals("2")){
            tabs.getTabAt(1).select();
        }
    }


}