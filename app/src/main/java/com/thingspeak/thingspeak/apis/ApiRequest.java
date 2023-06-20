package com.thingspeak.thingspeak.apis;

import com.thingspeak.thingspeak.model.Channel_Model;
import com.thingspeak.thingspeak.model.TempHumidity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

 // https://api.thingspeak.com/channels/1984207/fields/1.json?api_key=DAZGXH8X5X7HJUTX&results=2
 // @GET("/channels/1984207/fields/1.json?api_key=DAZGXH8X5X7HJUTX&results=2")
  //https://api.thingspeak.com/channels/1984207/status.json?api_key=DAZGXH8X5X7HJUTX
 //https://api.thingspeak.com/channels/1984207/feeds.json?api_key=DAZGXH8X5X7HJUTX&results
 // @GET("/channels/1984207/status.json?api_key=DAZGXH8X5X7HJUTX")
  //@GET("/channels/1984207/status.json")
  //@FormUrlEncoded
   // Call<JsonObject> getthinkData();
 @GET("/channels/1984207/feeds.json?api_key=DAZGXH8X5X7HJUTX&results")
  Call<Channel_Model> getthinkData();
 // get the temp and humidity values
 @GET("/channels/2195608/feeds.json?api_key=LY1ET7MNJXDVTI96&results=2")
 Call<TempHumidity> getTempAndHumidity();

}
//https://api.thingspeak.com/channels/1984207/feeds.json?api_key=DAZGXH8X5X7HJUTX&results=2