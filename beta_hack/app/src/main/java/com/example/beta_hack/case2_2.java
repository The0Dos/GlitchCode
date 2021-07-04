package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class case2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case22);
    }

    public void gotest2(View view) {
        Intent intent = new Intent(case2_2.this, card_swipe2.class);
        startActivity(intent);
    }
}