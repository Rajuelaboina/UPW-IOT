package com.thingspeak.thingspeak.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.thingspeak.thingspeak.HomeActivity;
import com.thingspeak.thingspeak.LoginActivity;
import com.thingspeak.thingspeak.model.User;

public class SharedPrefManager {
    private Context context;
    private static SharedPrefManager sharedPrefManager;
    SharedPreferences sharedPreferences;
    public SharedPrefManager(Context context) {
        this.context = context;
    }
    public static SharedPrefManager getSharedPrefInstance(Context context){
        if (sharedPrefManager ==null){
            sharedPrefManager = new SharedPrefManager(context);
        }
        return sharedPrefManager;
    }
    public void insetUserData(User user){
       SharedPreferences sharedPreferences = context.getSharedPreferences("MyIOTSharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", user.getName());
        myEdit.putString("password", user.getPassword());
        myEdit.putBoolean("OK",true);
        myEdit.commit();
    }
    public  User getUserData(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyIOTSharedPref",MODE_PRIVATE);
       return new User(sharedPreferences.getString("name",null),
                sharedPreferences.getString("password",null));
    }
    public void isLogedout(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyIOTSharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent=new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

    }
    public boolean isUserLoggedIn(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyIOTSharedPref",MODE_PRIVATE);
        if (sharedPreferences.getString("name",null) !=null){
            return true;
        }
        return false;
    }

}
