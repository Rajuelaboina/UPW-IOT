package com.thingspeak.thingspeak.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String getDate(String str){
        SimpleDateFormat parser = null;
        String date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            //  Log.i("DATE><<<<<<<<", "" + list.get(position).getCreated_at());
            try
            {
                Date parsed = parser.parse(str);
                SimpleDateFormat input = new SimpleDateFormat("dd-MM-YYYY");
                date= input.format(parsed);

            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return date;
    }

    // Display from Time ///

    public static String getCurrentTime(String str){
        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat parser = null;
        String time = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            try
            {
                Date parsed = parser.parse(str);
                SimpleDateFormat input = new SimpleDateFormat("HH:mm:ss");
                time= input.format(parsed);
                //String formatted = output.format(parsed);
               // Log.i("DATE", "" + formatted);
               // Log.i("DATE", "" + time);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return time;
    }
    public static String getDateTime(String str){
        SimpleDateFormat parser = null;
        String date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            //  Log.i("DATE><<<<<<<<", "" + list.get(position).getCreated_at());
            try
            {
                Date parsed = parser.parse(str);
                SimpleDateFormat input = new SimpleDateFormat("MMM-dd-YYYY HH:mm:ss");
                date= input.format(parsed);

            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return date;
    }
}
