package com.thingspeak.thingspeak.model;

import java.util.List;

public class Channel_Model {
   Channel channel;
   List<Feed> feeds;

   public Channel_Model( Channel channel, List<Feed> feeds) {
      this.channel = channel;
      this.feeds = feeds;
   }

   public Channel getChannel() {
      return channel;
   }

   public List<Feed> getFeeds() {
      return feeds;
   }


}
