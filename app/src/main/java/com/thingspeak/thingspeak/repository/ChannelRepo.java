package com.thingspeak.thingspeak.repository;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.thingspeak.thingspeak.adapter.ChannelAdapter;
import com.thingspeak.thingspeak.apis.ApiRequest;
import com.thingspeak.thingspeak.apis.RetrofitRequest;
import com.thingspeak.thingspeak.model.Channel;
import com.thingspeak.thingspeak.model.Channel_Model;
import com.thingspeak.thingspeak.model.Channel_Temp;
import com.thingspeak.thingspeak.model.Feed;
import com.thingspeak.thingspeak.model.Feed_Temp;
import com.thingspeak.thingspeak.model.TempHumidity;
import com.thingspeak.thingspeak.ui.main.TDSFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChannelRepo {
    ExecutorService executor;
    Handler handler;
    MutableLiveData<List<Feed>> feedList;
    MutableLiveData<Channel> channelList ;

    MutableLiveData<List<Feed_Temp>> tempFeedList;
    MutableLiveData<Channel_Temp> tempChannelList;
    ApiRequest apiRequest;
    Retrofit retrofit;
    Channel channel;
    public ChannelRepo() {
        tempFeedList=new MutableLiveData<>();
        tempChannelList=new MutableLiveData<>();
        feedList=new MutableLiveData<>();
        channelList = new MutableLiveData<>();
         retrofit= RetrofitRequest.getInstance();
        apiRequest=retrofit.create(ApiRequest.class);
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        getAllData();
        getTempHumidity();
    }
    public void getAllData(){

        executor.execute(new Runnable() {
            @Override
            public void run() {
              //background
                Call<Channel_Model> call=apiRequest.getthinkData();
                call.enqueue(new Callback<Channel_Model>() {
                    @Override
                    public void onResponse(@NonNull Call<Channel_Model> call, @NonNull Response<Channel_Model> response) {
                      // TDSFragment.progressBar.setVisibility(View.INVISIBLE);
                        if (response.isSuccessful()) {
                            // Log.e("name", "><<<<<" + response.body().getChannel().name);
                            channelList.setValue(response.body().getChannel());
                           // Log.e("name", "Name ><<<<<: " + response.body().getChannel().getName());
                           feedList.setValue(response.body().getFeeds());
                           // Log.e("name", "Name <<<< : " + response.body().getFeeds().get(0).getField1());

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Channel_Model> call, @NonNull Throwable t) {
                       // TDSFragment.progressBar.setVisibility(View.INVISIBLE);
                        channelList.setValue(null);
                       feedList.setValue(null);
                    }
                });

            }
        });

        // Update Ui
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public LiveData<List<Feed>> getAllFeeds(){
        return feedList;
    }

    public LiveData<Channel> getChannel(){
        return channelList;
    }

    private void getTempHumidity() {
        Call<TempHumidity> call=apiRequest.getTempAndHumidity();
        call.enqueue(new Callback<TempHumidity>() {
            @Override
            public void onResponse(Call<TempHumidity> call, Response<TempHumidity> response) {
                if (response.isSuccessful())
                    tempChannelList.setValue(response.body().getChannel());
                    tempFeedList.setValue(response.body().getFeeds());
               // Log.e("TempHumidity", "TempHumidity ><<<<<: " + response.body().getFeeds().get(0).getField1());
                // Log.e("TempHumidity", "TempHumidity ><<<<<: " + response.body().getFeeds().get(0).getField2());
            }

            @Override
            public void onFailure(Call<TempHumidity> call, Throwable t) {
                tempChannelList.setValue(null);
                tempFeedList.setValue(null);
            }
        });
    }
    public LiveData<List<Feed_Temp>> getTempFeeds(){
        return tempFeedList;
    }

    public LiveData<Channel_Temp> getTempChannel(){
        return tempChannelList;
    }

}
