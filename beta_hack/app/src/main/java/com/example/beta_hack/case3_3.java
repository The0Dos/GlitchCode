package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class case3_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case33);
    }

    public void gotest3(View view) {
        Intent intent = new Intent(case3_3.this, card_swipe3.class);
        startActivity(intent);
    }
}