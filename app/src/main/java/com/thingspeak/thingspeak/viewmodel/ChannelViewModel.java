package com.thingspeak.thingspeak.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.thingspeak.thingspeak.model.Channel;
import com.thingspeak.thingspeak.model.Channel_Temp;
import com.thingspeak.thingspeak.model.Feed;
import com.thingspeak.thingspeak.model.Feed_Temp;
import com.thingspeak.thingspeak.repository.ChannelRepo;

import java.util.List;

public class ChannelViewModel extends AndroidViewModel {
    ChannelRepo channelRepo;
    LiveData<List<Feed>> feedList = new MutableLiveData<>() ;
    LiveData<Channel> channelList = new MutableLiveData<>() ;

    LiveData<List<Feed_Temp>> tempfeedList = new MutableLiveData<>() ;
    LiveData<Channel_Temp> tempchannelList = new MutableLiveData<>() ;
    Channel channel;
    public ChannelViewModel(@NonNull Application application) {
        super(application);
        channelRepo=new ChannelRepo();
       // channel=channelRepo.getChannel();

    }

    public LiveData<List<Feed>> getAllFeeds(){
        feedList=channelRepo.getAllFeeds();
        return feedList;
    }

    public LiveData<Channel> getChannel(){
        channelList=channelRepo.getChannel();
        return channelList;
    }
    public LiveData<Channel_Temp> getTempChannel(){
        tempchannelList=channelRepo.getTempChannel();
        return tempchannelList;
    }
    public LiveData<List<Feed_Temp>> getTempFeeds(){
        tempfeedList=channelRepo.getTempFeeds();
        return tempfeedList;
    }

}
