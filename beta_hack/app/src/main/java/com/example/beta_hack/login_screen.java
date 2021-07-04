package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class login_screen extends AppCompatActivity {
EditText etl, etp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

    }

    public void openOnBoard(View view) {

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Launch1", Context.MODE_PRIVATE);
        int launch = sp.getInt("Launch", -1);
        if(launch == 1){
            Intent intent = new Intent(login_screen.this, pred_story.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(login_screen.this, onboard_ac.class);
            startActivity(intent);
        }

    }
}