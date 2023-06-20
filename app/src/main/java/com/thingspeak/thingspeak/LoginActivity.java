package com.thingspeak.thingspeak;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thingspeak.thingspeak.model.User;
import com.thingspeak.thingspeak.utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {
    private EditText ed_name,ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_login = findViewById(R.id.Login_button);
        ed_name=findViewById(R.id.editTextTextPersonName);
        ed_password=findViewById(R.id.editTextTextPassword);

        boolean loginCheck = SharedPrefManager.getSharedPrefInstance(getApplicationContext()).isUserLoggedIn();
        if (loginCheck){
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }
        btn_login.setOnClickListener(view -> {
            String name=ed_name.getText().toString();
            String password=ed_password.getText().toString();

            if (isValidations(name,password)){
               if (name.equals("MSL") && password.equals("msl@2023")) {
                   //saveDataFromSharedPref(name,password);

                   SharedPrefManager.getSharedPrefInstance(getApplicationContext()).insetUserData(new User("MSL","msl@2023"));
                   startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                   finish();
               }else if(name.equals("user1") && password.equals("user1@2023")){
                   SharedPrefManager.getSharedPrefInstance(getApplicationContext()).insetUserData(new User("user1","user1@2023"));
                   startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                   finish();
               }else if(name.equals("user2") && password.equals("user2@2023")){
                   SharedPrefManager.getSharedPrefInstance(getApplicationContext()).insetUserData(new User("user2","user2@2023"));
                   startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                   finish();
               }
               else {
                   Toast.makeText(getApplicationContext(), "username or password is incorrect", Toast.LENGTH_SHORT).show();
               }
            }else {
                Toast.makeText(getApplicationContext(), "fields are not empty", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private boolean isValidations(String name, String password) {
        boolean boo=true;
        if (name.isEmpty() && password.isEmpty()){
            return false;
        }
        return boo;
    }
}