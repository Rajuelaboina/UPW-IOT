package com.thingspeak.thingspeak.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TempHumidity {
    @SerializedName("channel")
    private Channel_Temp channel;
    @SerializedName("feeds")
    private List<Feed_Temp> feeds;

    public Channel_Temp getChannel() {
        return channel;
    }

    public void setChannel(Channel_Temp channel) {
        this.channel = channel;
    }

    public List<Feed_Temp> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed_Temp> feeds) {
        this.feeds = feeds;
    }
}
