package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class case1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_1);
    }

    public void gotest1(View view) {
        Intent intent = new Intent(case1_1.this, card_swipe1.class);
        startActivity(intent);
    }
}